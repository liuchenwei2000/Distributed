/**
 * 
 */
package rmi.server;

import java.rmi.server.UnicastRemoteObject;

import javax.naming.Context;
import javax.naming.InitialContext;

import rmi.IQueryService;

/**
 * 生成服务器对象的服务器程序
 * <p>
 * 要访问服务器上的一个远程对象时，客户端首先需要一个本地的存根对象。
 * 那么客户端如何获取一个存根对象呢，最普通的方法是调用另一个服务对象上的一个远程方法，以返回值的方式取得存根对象。
 * 然而，这样一来又需要先获取另一个存根对象，如此一来，就演变成了先有蛋还是先有鸡的问题。
 * 第一个服务器对象总是要通过某种方式进行定位，RMI类库提供了自助注册服务来定位第一个服务器对象，就像本例一样。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2013-7-6
 */
public class QueryServiceServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Constructing server implementations...");
			// 创建一个服务器对象实例
			IQueryService service1 = new QueryServiceImplA();
			// 采用下面的方式，将一个普通对象导出成远程对象
			IQueryService service2 = (IQueryService) UnicastRemoteObject.exportObject(new QueryServiceImplB(), 0);
			
			System.out.println("Binding server implementations to registry...");
			/**
			 * 通过给自助注册服务提供一个名字和对象引用，就可以注册一个服务器对象。
			 * 这个名字应该是系统唯一的，并且客户端也需要通过指定这个名字来获取存根定位服务器对象。
			 * 自助注册服务只应该用来注册非常少的服务器对象，然后使用这些对象来定位其他的对象。
			 * RMI的命名服务已经被整合到JNDI服务中了。
			 */
			// 构建一个命名上下文，用来访问RMI注册表
			Context context = new InitialContext();
			// 将name和对象绑定，"rmi:"表示rmi协议，默认情况下主机是 localhost，端口是1099
			context.bind("rmi:query1", service1);
			context.bind("rmi://localhost:1099/query2", service2);
			
			System.out.println("Waiting for invokations from clients...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

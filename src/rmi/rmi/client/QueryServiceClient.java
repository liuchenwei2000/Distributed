/**
 * 
 */
package rmi.client;

import javax.naming.Context;
import javax.naming.InitialContext;

import rmi.IQueryService;

/**
 * 客户端程序
 * <p>
 * 对远程对象发起调用。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2013-7-6
 */
public class QueryServiceClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Client starts...");
			
			Context context = new InitialContext();
			/**
			 * 当远程方法被调用时，该接口变量指向一个存根对象。
			 * 客户端程序实际上并不知道那些对象的类型，而存根类以及相关的对象都是自动生成的。
			 */
			// 返回给定名字的对象
			IQueryService service = (IQueryService) context.lookup("rmi://localhost/query1");
			System.out.println("[query1]server message:\n" + service.getMessage());
			
			// 返回给定名字的对象
			service = (IQueryService) context.lookup("rmi://localhost:1099/query2");
			System.out.println("[query2]server message:\n" + service.getMessage());

			// 可以使用instanceof判断一个远程对象是否实现了某个接口
			if(service instanceof IQueryService){
				// do something
			}
			// 但是不能向下面那样进行判断，因为service指向的是一个存根对象，而不是服务器对象
//			if(service instanceof QueryServiceImpl)
			
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
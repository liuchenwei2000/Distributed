/**
 * 
 */
package rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import rmi.IQueryService;

/**
 * 远程对象接口的服务器端实现类
 * <p>
 * 服务器类通常继承自抽象类RemoteServer，但它仅仅定义了服务器对象与其远程存根之间通信的基本机制。
 * UnicastRemoteObject继承了RemoteServer，它的对象可供远程访问，对于一个服务器类而言，最简单的方式就是继承它。
 * UnicastRemoteObject对象会驻留在服务器上，当有客户端请求服务时，它必须存活着，并且能够通过TCP/IP协议访问。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2013-7-6
 */
public class QueryServiceImplA extends UnicastRemoteObject implements IQueryService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueryServiceImplA() throws RemoteException {
	}

	public String getMessage() throws RemoteException {
		// 模拟查询数据库这类只能在服务器端才能完成的工作
		String message = queryFomrDB();
		return message;
	}

	private String queryFomrDB() {
		try {
			return "Hello " + getClientHost() + ". Now is " + new Date().toString();
		} catch (ServerNotActiveException e) {
			e.printStackTrace();
		}
		return null;
	}
}
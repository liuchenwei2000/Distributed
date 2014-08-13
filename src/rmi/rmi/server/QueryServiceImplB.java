/**
 * 
 */
package rmi.server;

import java.rmi.RemoteException;
import java.util.Date;

import rmi.IQueryService;

/**
 * 远程对象接口的服务器端实现类
 * <p>
 * 需要注意的是，本类没有继承UnicastRemoteObject，而是采用在QueryServiceServer中生成服务器对象的方式。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2013-7-6
 */
public class QueryServiceImplB implements IQueryService {

	public String getMessage() throws RemoteException {
		// 模拟查询数据库这类只能在服务器端才能完成的工作
		String message = queryFomrDB();
		return message;
	}

	private String queryFomrDB() {
		return "Hello client. Now is " + new Date().toString();
	}
}
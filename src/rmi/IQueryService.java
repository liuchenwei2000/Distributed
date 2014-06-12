/**
 * 
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 远程对象接口
 * <p>
 * 客户端代码总是使用某个interface类型的变量来访问远程对象，但它实际上并不需要这些对象的拷贝。
 * 这些对象仍然位于服务器端，客户端代码只需要知道这些对象可以用来做什么，而它们的功能用接口来描述。
 * 这些接口是客户端和服务器端共享的，并且必须同时存在于客户端与服务器端。
 * <p>
 * 远程对象的所有接口都必须继承Remote接口。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2013-7-6
 */
public interface IQueryService extends Remote {

	/**
	 * 返回一个消息
	 * <p>
	 * 远程方法必须声明抛出RemoteException，因为远程方法调用与生俱来就缺乏可靠性，总是存在失败的可能。
	 * 比如服务器或者网络连接不可用，网络故障等等。
	 */
	public String getMessage() throws RemoteException;
}
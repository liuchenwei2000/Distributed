/**
 * 
 */
package rmi.para;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * BookStore远程接口
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2013-7-9
 */
public interface IBookStore extends Remote {

	/**
	 * 根据参数信息查询相应的Book对象
	 * <p>
	 * 在本方法中，BookInfo对象将作为参数由客户端传递给服务器，
	 * Book对象将作为返回结果由服务器传递给客户端，这两个类都需要实现Serializable接口。
	 */
	public Book findBook(BookInfo info) throws RemoteException;
	
	/**
	 * 根据参数信息删除相应的Book对象
	 */
	public boolean delete(BookInfo info) throws RemoteException;
}
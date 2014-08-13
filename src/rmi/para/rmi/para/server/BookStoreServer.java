/**
 * 
 */
package rmi.para.server;

import java.rmi.server.UnicastRemoteObject;

import javax.naming.Context;
import javax.naming.InitialContext;

import rmi.para.IBookStore;

/**
 * BookStore服务器程序
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2013-7-6
 */
public class BookStoreServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Constructing server implementations...");
			
			// 采用下面的方式，将一个普通对象导出成远程对象
			IBookStore bookstore = (IBookStore) UnicastRemoteObject.exportObject(new BookStoreImpl(), 0);
			
			System.out.println("Binding server implementations to registry...");
			
			Context context = new InitialContext();
			// 将IBookStore的实际对象注册到rmi注册表中
			context.bind("rmi:bookstore", bookstore);
			
			System.out.println("Waiting for invokations from clients...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
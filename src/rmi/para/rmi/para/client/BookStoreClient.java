/**
 * 
 */
package rmi.para.client;

import javax.naming.Context;
import javax.naming.InitialContext;

import rmi.para.Book;
import rmi.para.BookInfo;
import rmi.para.IBookStore;

/**
 * BookStore客户端
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2013-7-6
 */
public class BookStoreClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			/**
			 * 使用RMI的客户端程序应该安装一个安全管理器(如下)，用以控制动态加载存根的行为。
			 * <p>
			 * 如果所有的类(包括存根)在本地都是可用的，那么安全管理器就不是必须的了。
			 * 然而通常情况下，服务器程序在不断的进化，新的类不断地被添加到其中，那时就能体现动态加载类的好处了。
			 * 无论何时，只要从另一个地方加载代码，就需要一个安全管理器。
			 * applet已经具备了一个安全管理器，能够控制存根类的加载，当applet中用到RMI时，就不需要安装另外的安全管理器了。
			 */
//			System.setProperty("java.security.policy", "client.policy");
//			System.setSecurityManager(new SecurityManager());
			
			System.out.println("BookStoreClient starts...");
			
			Context context = new InitialContext();
			// 返回远程对象IBookStore，实际上是个存根(或代理)
			IBookStore bookstore = (IBookStore) context.lookup("rmi://localhost/bookstore");
			
			// 发起一次远程调用
			BookInfo info = new BookInfo("Thinking in Java", "Bruce Eckel");
			Book book = bookstore.findBook(info);
			System.out.println("find the book:\n" + book);
			
			// 发起第二次远程调用
			info = new BookInfo("Java in Action", "Tom Cruise");
			boolean b = bookstore.delete(info);
			if (b) {
				System.out.println(info.getName() + " has bean deleted.");
			}
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
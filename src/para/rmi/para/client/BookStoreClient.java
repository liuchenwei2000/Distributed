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
			System.out.println("BookStoreClient starts...");
			
			Context context = new InitialContext();
			// 返回远程对象IBookStore，实际上是个存根(或代理)
			IBookStore bookstore = (IBookStore) context.lookup("rmi://localhost/bookstore");
			// 发起一次远程调用
			Book book = bookstore.findBook(new BookInfo("Think in Java", "Bruce Eckel"));
			System.out.println("find the book:\n" + book);
			// 发起第二次远程调用
			book = bookstore.findBook(new BookInfo("Design Pattern", "Gof"));
			System.out.println("find the book:\n" + book);
			
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
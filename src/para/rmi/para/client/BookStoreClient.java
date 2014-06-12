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
 * BookStore�ͻ���
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2013-7-6
 */
public class BookStoreClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("BookStoreClient starts...");
			
			Context context = new InitialContext();
			// ����Զ�̶���IBookStore��ʵ�����Ǹ����(�����)
			IBookStore bookstore = (IBookStore) context.lookup("rmi://localhost/bookstore");
			// ����һ��Զ�̵���
			Book book = bookstore.findBook(new BookInfo("Think in Java", "Bruce Eckel"));
			System.out.println("find the book:\n" + book);
			// ����ڶ���Զ�̵���
			book = bookstore.findBook(new BookInfo("Design Pattern", "Gof"));
			System.out.println("find the book:\n" + book);
			
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
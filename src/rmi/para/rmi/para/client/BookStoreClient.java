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
			/**
			 * ʹ��RMI�Ŀͻ��˳���Ӧ�ð�װһ����ȫ������(����)�����Կ��ƶ�̬���ش������Ϊ��
			 * <p>
			 * ������е���(�������)�ڱ��ض��ǿ��õģ���ô��ȫ�������Ͳ��Ǳ�����ˡ�
			 * Ȼ��ͨ������£������������ڲ��ϵĽ������µ��಻�ϵر���ӵ����У���ʱ�������ֶ�̬������ĺô��ˡ�
			 * ���ۺ�ʱ��ֻҪ����һ���ط����ش��룬����Ҫһ����ȫ��������
			 * applet�Ѿ��߱���һ����ȫ���������ܹ����ƴ����ļ��أ���applet���õ�RMIʱ���Ͳ���Ҫ��װ����İ�ȫ�������ˡ�
			 */
//			System.setProperty("java.security.policy", "client.policy");
//			System.setSecurityManager(new SecurityManager());
			
			System.out.println("BookStoreClient starts...");
			
			Context context = new InitialContext();
			// ����Զ�̶���IBookStore��ʵ�����Ǹ����(�����)
			IBookStore bookstore = (IBookStore) context.lookup("rmi://localhost/bookstore");
			
			// ����һ��Զ�̵���
			BookInfo info = new BookInfo("Thinking in Java", "Bruce Eckel");
			Book book = bookstore.findBook(info);
			System.out.println("find the book:\n" + book);
			
			// ����ڶ���Զ�̵���
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
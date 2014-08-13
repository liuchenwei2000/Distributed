/**
 * 
 */
package rmi.para.server;

import java.rmi.server.UnicastRemoteObject;

import javax.naming.Context;
import javax.naming.InitialContext;

import rmi.para.IBookStore;

/**
 * BookStore����������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2013-7-6
 */
public class BookStoreServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Constructing server implementations...");
			
			// ��������ķ�ʽ����һ����ͨ���󵼳���Զ�̶���
			IBookStore bookstore = (IBookStore) UnicastRemoteObject.exportObject(new BookStoreImpl(), 0);
			
			System.out.println("Binding server implementations to registry...");
			
			Context context = new InitialContext();
			// ��IBookStore��ʵ�ʶ���ע�ᵽrmiע�����
			context.bind("rmi:bookstore", bookstore);
			
			System.out.println("Waiting for invokations from clients...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
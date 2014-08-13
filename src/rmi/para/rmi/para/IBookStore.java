/**
 * 
 */
package rmi.para;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * BookStoreԶ�̽ӿ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2013-7-9
 */
public interface IBookStore extends Remote {

	/**
	 * ���ݲ�����Ϣ��ѯ��Ӧ��Book����
	 * <p>
	 * �ڱ������У�BookInfo������Ϊ�����ɿͻ��˴��ݸ���������
	 * Book������Ϊ���ؽ���ɷ��������ݸ��ͻ��ˣ��������඼��Ҫʵ��Serializable�ӿڡ�
	 */
	public Book findBook(BookInfo info) throws RemoteException;
	
	/**
	 * ���ݲ�����Ϣɾ����Ӧ��Book����
	 */
	public boolean delete(BookInfo info) throws RemoteException;
}
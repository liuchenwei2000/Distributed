/**
 * 
 */
package rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import rmi.IQueryService;

/**
 * Զ�̶���ӿڵķ�������ʵ����
 * <p>
 * ��������ͨ���̳��Գ�����RemoteServer���������������˷�������������Զ�̴��֮��ͨ�ŵĻ������ơ�
 * UnicastRemoteObject�̳���RemoteServer�����Ķ���ɹ�Զ�̷��ʣ�����һ������������ԣ���򵥵ķ�ʽ���Ǽ̳�����
 * UnicastRemoteObject�����פ���ڷ������ϣ����пͻ����������ʱ�����������ţ������ܹ�ͨ��TCP/IPЭ����ʡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2013-7-6
 */
public class QueryServiceImplA extends UnicastRemoteObject implements IQueryService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueryServiceImplA() throws RemoteException {
	}

	public String getMessage() throws RemoteException {
		// ģ���ѯ���ݿ�����ֻ���ڷ������˲�����ɵĹ���
		String message = queryFomrDB();
		return message;
	}

	private String queryFomrDB() {
		try {
			return "Hello " + getClientHost() + ". Now is " + new Date().toString();
		} catch (ServerNotActiveException e) {
			e.printStackTrace();
		}
		return null;
	}
}
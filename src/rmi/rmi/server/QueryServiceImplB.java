/**
 * 
 */
package rmi.server;

import java.rmi.RemoteException;
import java.util.Date;

import rmi.IQueryService;

/**
 * Զ�̶���ӿڵķ�������ʵ����
 * <p>
 * ��Ҫע����ǣ�����û�м̳�UnicastRemoteObject�����ǲ�����QueryServiceServer�����ɷ���������ķ�ʽ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2013-7-6
 */
public class QueryServiceImplB implements IQueryService {

	public String getMessage() throws RemoteException {
		// ģ���ѯ���ݿ�����ֻ���ڷ������˲�����ɵĹ���
		String message = queryFomrDB();
		return message;
	}

	private String queryFomrDB() {
		return "Hello client. Now is " + new Date().toString();
	}
}
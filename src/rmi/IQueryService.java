/**
 * 
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Զ�̶���ӿ�
 * <p>
 * �ͻ��˴�������ʹ��ĳ��interface���͵ı���������Զ�̶��󣬵���ʵ���ϲ�����Ҫ��Щ����Ŀ�����
 * ��Щ������Ȼλ�ڷ������ˣ��ͻ��˴���ֻ��Ҫ֪����Щ�������������ʲô�������ǵĹ����ýӿ���������
 * ��Щ�ӿ��ǿͻ��˺ͷ������˹���ģ����ұ���ͬʱ�����ڿͻ�����������ˡ�
 * <p>
 * Զ�̶�������нӿڶ�����̳�Remote�ӿڡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2013-7-6
 */
public interface IQueryService extends Remote {

	/**
	 * ����һ����Ϣ
	 * <p>
	 * Զ�̷������������׳�RemoteException����ΪԶ�̷�����������������ȱ���ɿ��ԣ����Ǵ���ʧ�ܵĿ��ܡ�
	 * ��������������������Ӳ����ã�������ϵȵȡ�
	 */
	public String getMessage() throws RemoteException;
}
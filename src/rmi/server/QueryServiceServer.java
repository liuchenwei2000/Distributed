/**
 * 
 */
package rmi.server;

import java.rmi.server.UnicastRemoteObject;

import javax.naming.Context;
import javax.naming.InitialContext;

import rmi.IQueryService;

/**
 * ���ɷ���������ķ���������
 * <p>
 * Ҫ���ʷ������ϵ�һ��Զ�̶���ʱ���ͻ���������Ҫһ�����صĴ������
 * ��ô�ͻ�����λ�ȡһ����������أ�����ͨ�ķ����ǵ�����һ����������ϵ�һ��Զ�̷������Է���ֵ�ķ�ʽȡ�ô������
 * Ȼ��������һ������Ҫ�Ȼ�ȡ��һ������������һ�������ݱ�������е��������м������⡣
 * ��һ����������������Ҫͨ��ĳ�ַ�ʽ���ж�λ��RMI����ṩ������ע���������λ��һ�����������󣬾�����һ����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2013-7-6
 */
public class QueryServiceServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Constructing server implementations...");
			// ����һ������������ʵ��
			IQueryService service1 = new QueryServiceImplA();
			// ��������ķ�ʽ����һ����ͨ���󵼳���Զ�̶���
			IQueryService service2 = (IQueryService) UnicastRemoteObject.exportObject(new QueryServiceImplB(), 0);
			
			System.out.println("Binding server implementations to registry...");
			/**
			 * ͨ��������ע������ṩһ�����ֺͶ������ã��Ϳ���ע��һ������������
			 * �������Ӧ����ϵͳΨһ�ģ����ҿͻ���Ҳ��Ҫͨ��ָ�������������ȡ�����λ����������
			 * ����ע�����ֻӦ������ע��ǳ��ٵķ���������Ȼ��ʹ����Щ��������λ�����Ķ���
			 * RMI�����������Ѿ������ϵ�JNDI�������ˡ�
			 */
			// ����һ�����������ģ���������RMIע���
			Context context = new InitialContext();
			// ��name�Ͷ���󶨣�"rmi:"��ʾrmiЭ�飬Ĭ������������� localhost���˿���1099
			context.bind("rmi:query1", service1);
			context.bind("rmi://localhost:1099/query2", service2);
			
			System.out.println("Waiting for invokations from clients...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
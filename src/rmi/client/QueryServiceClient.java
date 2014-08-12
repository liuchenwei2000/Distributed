/**
 * 
 */
package rmi.client;

import javax.naming.Context;
import javax.naming.InitialContext;

import rmi.IQueryService;

/**
 * �ͻ��˳���
 * <p>
 * ��Զ�̶�������á�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2013-7-6
 */
public class QueryServiceClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Client starts...");
			/**
			 * ʹ��RMI�Ŀͻ��˳���Ӧ�ð�װһ����ȫ������(����)�����Կ��ƶ�̬���ش������Ϊ��
			 * <p>
			 * ������е���(�������)�ڱ��ض��ǿ��õģ���ô��ȫ�������Ͳ��Ǳ�����ˡ�
			 * Ȼ��ͨ������£������������ڲ��ϵĽ������µ��಻�ϵر���ӵ����У���ʱ�������ֶ�̬������ĺô��ˡ�
			 * ���ۺ�ʱ��ֻҪ����һ���ط����ش��룬����Ҫһ����ȫ��������
			 * applet�Ѿ��߱���һ����ȫ���������ܹ����ƴ����ļ��أ���applet���õ�RMIʱ���Ͳ���Ҫ��װ����İ�ȫ�������ˡ�
			 */
//			System.setSecurityManager(new RMISecurityManager());
			
			Context context = new InitialContext();
			/**
			 * ��Զ�̷���������ʱ���ýӿڱ���ָ��һ���������
			 * �ͻ��˳���ʵ���ϲ���֪����Щ��������ͣ���������Լ���صĶ������Զ����ɵġ�
			 */
			// ���ظ������ֵĶ���
			IQueryService service = (IQueryService) context.lookup("rmi://localhost/query1");
			System.out.println("[query1]server message:\n" + service.getMessage());
			
			// ���ظ������ֵĶ���
			service = (IQueryService) context.lookup("rmi://localhost:1099/query2");
			System.out.println("[query2]server message:\n" + service.getMessage());

			// ����ʹ��instanceof�ж�һ��Զ�̶����Ƿ�ʵ����ĳ���ӿ�
			if(service instanceof IQueryService){
				// do something
			}
			// ���ǲ������������������жϣ���Ϊserviceָ�����һ��������󣬶����Ƿ���������
//			if(service instanceof QueryServiceImpl)
			
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
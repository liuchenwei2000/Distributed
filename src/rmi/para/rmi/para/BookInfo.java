/**
 * 
 */
package rmi.para;

import java.io.Serializable;

/**
 * BookInfo��
 * <p>
 * ��Ϊ��ͨ�����紫�ݵĶ���ʵ����Serializable�ӿڡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2013-7-9
 */
public class BookInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String author;

	public BookInfo(String name, String author) {
		this.name = name;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
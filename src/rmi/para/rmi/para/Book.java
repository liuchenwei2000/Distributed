/**
 * 
 */
package rmi.para;

import java.io.Serializable;

/**
 * Book��
 * <p>
 * ��Ϊ��ͨ�����紫�ݵĶ���ʵ����Serializable�ӿڡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2013-7-9
 */
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ISBN;
	private String author;
	private String name;
	private double price;
	private int stock;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String toString() {
		return "Name��" + name + "\nAuthor��" + author + "\nISBN��" + ISBN
				+ "\nPrice��" + price + "\nStock��" + stock;
	}
}
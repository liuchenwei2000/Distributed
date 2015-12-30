/**
 * 
 */
package rmi.para.server;

import java.rmi.RemoteException;

import rmi.para.Book;
import rmi.para.BookInfo;
import rmi.para.IBookStore;

/**
 * BookStore实现类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2013-7-9
 */
public class BookStoreImpl implements IBookStore {

	public BookStoreImpl() {
		super();
	}

	public Book findBook(BookInfo info) throws RemoteException {
		String name = info.getName();
		String author = info.getAuthor();
		return queryDB(name, author);
	}

	/**
	 * 模拟查询数据库
	 */
	private Book queryDB(String name, String author) {
		// query db
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setISBN("89197209" + random() + "01");
		book.setPrice(random());
		book.setStock(random() * 2);
		return book;
	}

	private int random() {
		return (int) (Math.random() * 100);
	}

	public boolean delete(BookInfo info) throws RemoteException {
		return true;
	}
}

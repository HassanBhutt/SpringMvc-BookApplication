package acp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import acp.dao.BooksDao;
import acp.entities.Book;
import acp.entities.Category;

@Component("MyBooksService")
public class BooksService {

	@Autowired
	private BooksDao booksDao;

	public String insertBook(Book books) {
		return booksDao.insertBook(books);
	}

	public List<Category> getCategories() {
		return booksDao.getCategories();
	}

	public List<Book> getBooks() {
		return booksDao.getbooks();
	}

	public String deleteBook(double id) {
		return booksDao.deleteBook(id);
	}

	public List<Book> getsearchBook1(String title, String author, int catId) {
		return booksDao.getSearchBook1(title, author, catId);
	}

	public BooksDao getBooksDao() {
		return booksDao;
	}

	public void setEmployeeDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

}

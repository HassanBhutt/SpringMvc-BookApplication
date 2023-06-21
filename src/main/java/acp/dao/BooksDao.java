package acp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import acp.entities.Book;
import acp.entities.Category;
import acp.mappers.BooksRowMapper;
import acp.mappers.CategoriesRowMapper;

@Component
public class BooksDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertBook(Book books) {
		String checkQuery = "select exists (select * from books WHERE title = ?) as is_valid";
		int count = jdbcTemplate.queryForObject(checkQuery, Integer.class, books.getTitle());

		if (count > 0) {
			System.out.println("Book title already added here");
			return count > 0;
		} else {
			String insertSQL = "insert into books" + "(title,author,category_id) " + "values(?,?,?)";
			int result = jdbcTemplate.update(insertSQL, books.getTitle(), books.getAuthor(), books.getCatId());
			System.out.println("Number of records inserted: " + result);
			return false;
		}
	}

	public boolean deleteBook(double id) {

		String deleteQuery = "delete from books where id = ? ";
		int result = jdbcTemplate.update(deleteQuery, id);
		if (result > 0) {
			System.out.println("Numbers of records deleted are " + result);
			return false;
		} else {
			System.out.println("Numbers of records deleted are " + result);
			return true;
		}

	}

	public List<Book> getbooks() {
		String query = "select books.id, books.title, books.author, categories.name from books inner join categories on books.category_id = categories.id";
		List<Book> books = jdbcTemplate.query(query, new BooksRowMapper());
		return books;

	}

	public List<Category> getCategories() {
		String query = "select * from categories";
		List<Category> categories = jdbcTemplate.query(query, new CategoriesRowMapper());
		return categories;

	}

	public List<Book> getSearchBook1(String title, String author, int catId) {

		StringBuilder query = new StringBuilder("SELECT books.id, books.title, books.author, categories.name "
				+ "FROM books " + "INNER JOIN categories ON books.category_id = categories.id " + "WHERE 1=1");

		if (title != null && !title.isEmpty()) {
			query.append(" AND books.title LIKE '%" + title + "%'");
		}

		if (author != null && !author.isEmpty()) {
			query.append(" AND books.author LIKE '%" + author + "%'");
		}

		if (catId != 0) {
			query.append(" AND categories.id = " + catId);
		}

		List<Book> books = jdbcTemplate.query(query.toString(), new BooksRowMapper());
		System.out.println(books);
		return books;
	}

}


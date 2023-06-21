package acp.controllers;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import acp.service.BooksService;
import acp.configurations.Configurations;
import acp.entities.Book;

@Controller
public class BookController {

	@RequestMapping("/")
	public String index(Model model) {
		AnnotationConfigApplicationContext xtr = new AnnotationConfigApplicationContext(Configurations.class);
		BooksService es = xtr.getBean("MyBooksService", BooksService.class);
		model.addAttribute("books", es.getBooks());
		xtr.close();
		return "index";
	}

	@RequestMapping("/addBook")
	public String addBook(Model model) {
		AnnotationConfigApplicationContext xtr = new AnnotationConfigApplicationContext(Configurations.class);
		BooksService es = xtr.getBean("MyBooksService", BooksService.class);
		model.addAttribute("categories", es.getCategories());
		xtr.close();
		return "addBook";
	}

	@RequestMapping("/BookError")
	public String bookExistError() {
		return "error";
	}

	@RequestMapping("/BookIdError")
	public String BookIdError() {
		return "error1";
	}

	@RequestMapping(path = "/addABook", method = RequestMethod.POST)
	public String addBook(@ModelAttribute Book book, Model model) {
		AnnotationConfigApplicationContext xtr = new AnnotationConfigApplicationContext(Configurations.class);

		BooksService es = xtr.getBean("MyBooksService", BooksService.class);
		boolean result = es.insertBook(book);
		xtr.close();
		return result ? "redirect:/BookError" : "redirect:/";

	}

	@RequestMapping(path = "/Delete", method = RequestMethod.GET)
	public String deleteBook(@RequestParam("Id") double id) {
		AnnotationConfigApplicationContext xtr = new AnnotationConfigApplicationContext(Configurations.class);

		BooksService es = xtr.getBean("MyBooksService", BooksService.class);
		boolean result = es.deleteBook(id);
		xtr.close();
		return result ? "redirect:/BookIdError" : "redirect:/";

	}

	@RequestMapping("/searchBook")
	public String searchBook(Model model) {
		AnnotationConfigApplicationContext xtr = new AnnotationConfigApplicationContext(Configurations.class);
		BooksService es = xtr.getBean("MyBooksService", BooksService.class);
		model.addAttribute("categories", es.getCategories());
		xtr.close();
		return "searchBook";

	}

	@RequestMapping(path = "/BookForSearch", method = RequestMethod.POST)
	public String bookForSearch(@RequestParam("title") String title, @RequestParam("author") String author,
			@RequestParam("catId") int catId, Model model) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configurations.class);
		BooksService booksService = context.getBean("MyBooksService", BooksService.class);

		List<Book> books = booksService.getsearchBook1(title, author, catId);

		model.addAttribute("books", books);
		model.addAttribute("categories", booksService.getCategories());
		context.close();
		return "searchBook";
	}

}


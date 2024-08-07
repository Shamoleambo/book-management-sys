package com.tidz.book_management_sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tidz.book_management_sys.entity.Book;
import com.tidz.book_management_sys.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public String getBooks(Model model) {
		List<Book> books = this.bookService.getAllBooks();
		model.addAttribute("books", books);
		return "books";
	}

	@GetMapping("/new")
	public String showNewBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "new_book";
	}
}

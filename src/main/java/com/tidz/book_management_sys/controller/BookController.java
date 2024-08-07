package com.tidz.book_management_sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping
	public String saveBook(@ModelAttribute("book") Book book) {
		this.bookService.saveBook(book);
		return "redirect:/books";
	}

	@GetMapping("/edit/{id}")
	public String showEditBookForm(@PathVariable("id") Long id, Model model) {
		Book book = this.bookService.getBookById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid book id: " + id));
		model.addAttribute("book", book);
		return "edit_book";
	}

	@PostMapping("/{id}")
	public String updateBook(@PathVariable("id") Long id, @ModelAttribute Book book) {
		book.setId(id);
		this.bookService.saveBook(book);
		return "redirect:/books";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		this.bookService.deleteBookById(id);
		return "redirect:/books";
	}
}

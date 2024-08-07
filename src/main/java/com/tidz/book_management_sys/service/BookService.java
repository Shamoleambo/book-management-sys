package com.tidz.book_management_sys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tidz.book_management_sys.entity.Book;
import com.tidz.book_management_sys.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	public List<Book> getAllBooks() {
		return this.bookRepo.findAll();
	}

	public Optional<Book> getBookById(Long id) {
		return this.bookRepo.findById(id);
	}

	public Book saveBook(Book book) {
		return this.bookRepo.save(book);
	}

	public void deleteBookById(Long id) {
		this.bookRepo.deleteById(id);
	}
}

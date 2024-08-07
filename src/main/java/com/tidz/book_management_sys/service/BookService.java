package com.tidz.book_management_sys.service;

import java.util.List;

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
}

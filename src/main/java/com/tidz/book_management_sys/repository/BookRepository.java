package com.tidz.book_management_sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tidz.book_management_sys.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}

package com.genpact.librarymgmt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.librarymgmt.dao.BookRepository;
import com.genpact.librarymgmt.model.Book;
import com.genpact.librarymgmt.model.CustomException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	public Book getBook(Integer bookId) throws CustomException {
		Optional<Book> bookDetails = bookRepo.findById(bookId);
		if (bookDetails.isPresent()) {
			return bookDetails.get();
		} else {
			throw new CustomException("Book not found!");
		}
	}

	public void addBook(Book book) {
		bookRepo.save(book);
	}

	public void updateBook(Integer bookId, Book book) throws CustomException {
		try {
			Book bookDetails = getBook(bookId);
			bookDetails.setAuthor(book.getAuthor());
			bookDetails.setCategory(book.getCategory());
			bookDetails.setName(book.getName());
			bookDetails.setPublishedOn(book.getPublishedOn());
			bookRepo.save(bookDetails);
		} catch (CustomException exception) {
			throw exception;
		}

	}

}

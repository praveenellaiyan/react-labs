package com.genpact.librarymgmt.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.librarymgmt.model.AppMessage;
import com.genpact.librarymgmt.model.Book;
import com.genpact.librarymgmt.model.CustomException;
import com.genpact.librarymgmt.service.BookService;

@RestController
@RequestMapping(path = "/books")
public class BookResource {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(path = "/{bookId}", method = RequestMethod.GET)
	public Book getBook(@PathVariable("bookId") Integer bookId) throws CustomException {
		return bookService.getBook(bookId);
	}
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<AppMessage> addBook(@RequestBody Book book) {
		bookService.addBook(book);
		AppMessage response = new AppMessage("Book added!");
		return new ResponseEntity<AppMessage>(response, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{bookId}", method = RequestMethod.PUT)
	public ResponseEntity<AppMessage> updateBook(@PathVariable("bookId") Integer bookId, @RequestBody Book book) throws CustomException {
		bookService.updateBook(bookId, book);
		AppMessage response = new AppMessage("Book updated!");
		return new ResponseEntity<AppMessage>(response, HttpStatus.OK);
	}

}

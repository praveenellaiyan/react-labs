package com.genpact.librarymgmt.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.librarymgmt.model.Book;
import com.genpact.librarymgmt.model.CustomException;
import com.genpact.librarymgmt.model.Library;
import com.genpact.librarymgmt.service.LibraryService;

@RestController
@RequestMapping(path = "/library")
public class LibraryResource {
	
	@Autowired
	private LibraryService libraryService;
	
	@RequestMapping(path = "/{libraryId}", method = RequestMethod.GET)
	public List<Book> getAllBooks(@PathVariable(name = "libraryId") Integer libraryId) throws CustomException {
		return libraryService.getAllBooks(libraryId);		
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Library> getAll() {
		return libraryService.getAll();		
	}

}

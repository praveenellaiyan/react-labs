package com.genpact.librarymgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.librarymgmt.dao.LibraryRepositiry;
import com.genpact.librarymgmt.model.Book;
import com.genpact.librarymgmt.model.CustomException;
import com.genpact.librarymgmt.model.Library;

@Service
public class LibraryService {

	@Autowired
	private LibraryRepositiry libraryRepo;

	public List<Book> getAllBooks(Integer libraryId) throws CustomException {
		Optional<Library> libraryDetails = libraryRepo.findById(libraryId);
		if (libraryDetails.isPresent()) {
			return libraryDetails.get().getBooks();
		} else {
			throw new CustomException("Library not available!");
		}
	}

	public List<Library> getAll() {
		return libraryRepo.findAll();
	}

}

package com.genpact.librarymgmt;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.genpact.librarymgmt.dao.BookRepository;
import com.genpact.librarymgmt.dao.LibraryRepositiry;
import com.genpact.librarymgmt.model.Book;
import com.genpact.librarymgmt.model.Library;

@SpringBootApplication
public class LibraryMgmtApplication implements ApplicationRunner {

	@Autowired
	private LibraryRepositiry libraryRepo;
	
	@Autowired
	private BookRepository bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(LibraryMgmtApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Book fivepointBook = new Book("Five Point Someone", "Chetan Bhagat", "Novel", LocalDate.of(2004, Month.APRIL, 1));
		Book revolutionBook = new Book("Revolution 2020", "Chetan Bhagat", "Fiction", LocalDate.of(2011, Month.JULY, 1));
		Library libraryOne = new Library("Central Library", "Coimbatore");
		libraryOne.addBook(bookRepo.save(fivepointBook));
		libraryOne.addBook(bookRepo.save(revolutionBook));
		
		Book agniBook = new Book("Agni ki Udaan", "A. P. J. Abdul Kalam", "Biography", LocalDate.of(1999, Month.APRIL, 1));
		Book india2020Book = new Book("India 2020", "A. P. J. Abdul Kalam", "Inspirational Fiction", LocalDate.of(1998, Month.JULY, 1));
		Library libraryTwo = new Library("MGR Library", "Chennai");
		libraryTwo.addBook(bookRepo.save(agniBook));
		libraryTwo.addBook(bookRepo.save(india2020Book));

		libraryRepo.save(libraryOne);
		libraryRepo.save(libraryTwo);

	}

}

@Configuration
class AppConfig {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
	
}

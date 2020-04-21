package com.genpact.librarymgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genpact.librarymgmt.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}

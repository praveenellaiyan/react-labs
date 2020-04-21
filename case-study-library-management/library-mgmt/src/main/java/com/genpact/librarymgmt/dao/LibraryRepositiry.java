package com.genpact.librarymgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genpact.librarymgmt.model.Library;

@Repository
public interface LibraryRepositiry extends JpaRepository<Library, Integer> {

}

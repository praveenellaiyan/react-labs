package com.genpact.librarymgmt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@Data
public class Library implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer libraryId;

	@Column
	private String name;

	@Column
	private String address;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn
	private List<Book> books;

	public void addBook(Book book) {
		if (books == null) {
			books = new ArrayList<>();
		}
		books.add(book);
	}

	public void removeBook(Book book) {
		books.remove(book);
	}

	public Library(String name, String address) {
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Library [libraryId=" + libraryId + ", name=" + name + "]";
	}
}

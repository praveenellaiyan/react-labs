package com.genpact.librarymgmt.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@Data
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;

	@Column
	private String name;

	@Column
	private String author;

	@Column
	private String category;

	@Column
	private LocalDate publishedOn;

	@Override
	public boolean equals(Object obj) {
		return this.getBookId() == ((Book) obj).getBookId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId);
	}

	public Book(String name, String author, String category, LocalDate publishedOn) {
		this.name = name;
		this.author = author;
		this.category = category;
		this.publishedOn = publishedOn;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + "]";
	}

}

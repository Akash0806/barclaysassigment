package com.api.librarymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	Long id;
	@Column
	String name;
	@Column
	String author;
	@Column(name = "number_copy")
	Integer numberofCopy;


}


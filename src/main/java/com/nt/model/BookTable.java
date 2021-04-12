package com.nt.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity

public class BookTable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	private String bookName;
	private String BookAurthore;
	private Integer qty;
	@ManyToOne
	@JoinColumn(name = "bookfk")
	private BookEdition editions;

}

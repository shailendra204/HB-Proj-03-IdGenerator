package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class BookEdition {
	@Id
   private String book_Edition;
   private Integer quantity;
}

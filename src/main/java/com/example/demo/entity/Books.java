package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="books")
public class Books {
	@Id
	
private int id;
	@NotBlank(message = "Bookname name can not be empty")
	  
	  @Size(max = 20,message = "Bookname name can't be more than 20 characters")
	  
	  @Size(min=2, message="Bookname name must be more than 5 characters")
	
private String book_name;
	@NotNull(message = "quantity can not be null")

@Column(name="quantity")
private int quantity;
@Size(max = 20,message = "Authorname name can't be more than 20 characters")
@Size(min=2, message="Authorname name must be more than 5 characters")
@Column(name="authorname")
private String authorname;
@NotNull(message = "Price can not be null")

@Max(value=10000, message ="Price should not be greater than 10000" )

@Min(value=10, message="price must be greater than 10")
private Double price;
@OneToMany(mappedBy="books")
private Set<Students>students;

public Books()
{
	
}

public Books(int id, String book_name, int quantity, String authorname,double price) {
	super();
	this.id = id;
	this.book_name = book_name;
	this.quantity = quantity;
	this.authorname = authorname;
	this.price=price;
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getBook_name() {
	return book_name;
}

public void setBook_name(String book_name) {
	this.book_name = book_name;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public String getAuthorname() {
	return authorname;
}

public void setAuthorname(String authorname) {
	this.authorname = authorname;
}


public Double getPrice() {
	return price;
}


public void setPrice(Double price) {
	this.price = price;
}

}

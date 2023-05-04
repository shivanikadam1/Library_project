package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name="librariandetails")
@Entity
public class Librarian {
	
	  @Column(name="id")
	  
	  @Id
	  
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	 
	private int id;
	
	
	 // @NotBlank(message = "Librarian name can not be empty")
	  
	  @Size(max = 20,message = "Librarian name can't be more than 20 characters")
	  
	  @Size(min=2, message="Librarian name must be more than 5 characters")
	 
	@Column(name="name")
	private String name;
	
	  @NotBlank(message = "Email  can not be empty")
	  
	  @Column(name="email")
	 
	private String email;
	
	
	  @NotBlank(message = "Address can not be empty")
	  
	  @Size(max = 20,message = "Address can't be more than 20 characters")
	  
	  @Size(min=2, message="Address must be more than 5 characters")
	 
	@Column(name="address")
	private String address;
	
	
	  @NotNull(message = "Contact can not be null")
	  
//	  @Max(value=10, message ="Contact should  be  10" )
//	  
	 
	@Column(name="contact")
	  
	private long contact;
	  @Column(name="username")
		private String username;
		
		@Column(name="password")
		private String password;

	
	public Librarian()
	{
		
	}

	public Librarian(int id, String name, String email, String address, long contact, String username, String password ) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.contact = contact;
		this.username = username;
		this.password = password;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	

	
	
}

package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Table(name="return_book")
@Entity
public class ReturnBook 
{
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sId")
	private int sId;
	@NotBlank(message = "sName name can not be empty")
	@Size(max = 20,message = "sName name can't be more than 20 characters")
	@Size(min=2, message="sName name must be more than 5 characters")
	@Column(name="sName")
	private String sName;
	@Column(name="BookId")
	private int bookid;
	@NotBlank(message = "Bookname name can not be empty")
	  
	  @Size(max = 20,message = "Bookname name can't be more than 20 characters")
	  
	  @Size(min=2, message="Bookname name must be more than 5 characters")
	 @Column(name="BookName")
      private String book_name;

	 @NotNull(message = "return can not be null")
	 @Column(name="ReturnDate")
	 private Date return_date;
	
	 public ReturnBook()
	 {
		 
	 }
	 public ReturnBook(int sId, String sName, int bookid, String book_name, Date return_date)
	 {
		 super();
			this.sId = sId;
			this.sName = sName;
			this.bookid = bookid;
			this.book_name = book_name;
			this.return_date = return_date;
	 }
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	
		
}

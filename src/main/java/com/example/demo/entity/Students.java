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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="students")
public class Students {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sId")
private int sId;
	@NotBlank(message = "sName name can not be empty")
	@Size(max = 20,message = "sName name can't be more than 20 characters")
	@Size(min=2, message="sName name must be more than 5 characters")
	@Column(name="sName")
private String sName;
	@NotBlank(message = "address name can not be empty")
	@Size(max = 20,message = "address name can't be more than 20 characters")
	@Size(min=2, message="address name must be more than 5 characters")
	@Column(name="address")
private String address;
	@NotBlank(message = "authorname name can not be empty")
	@Size(max = 20,message = "authorname name can't be more than 20 characters")
	@Size(min=2, message="authorname name must be more than 5 characters")
	@Column(name="branch")
private String branch;
	
private int bookid;
@NotNull(message = "issue Date can not be null")
private Date issue_date;
@NotNull(message = "return can not be null")
private Date return_date;
@ManyToOne(targetEntity=Books.class,fetch=FetchType.EAGER)
@JoinColumn(name="bookid",insertable = false,updatable = false)
private Books books;
public Students()
{
	
}
public Students(int sId, String sName, String address, String branch, int bookid, Date issue_date,
		Date return_date) {
	super();
	this.sId = sId;
	this.sName = sName;
	this.address = address;
	this.branch = branch;
	this.bookid = bookid;
	this.issue_date = issue_date;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public Date getIssue_date() {
	return issue_date;
}
public void setIssue_date(Date issue_date) {
	this.issue_date = issue_date;
}
public Date getReturn_date() {
	return return_date;
}
public void setReturn_date(Date return_date) {
	this.return_date = return_date;
}
public Books getBooks() {
	return books;
}
public void setBooks(Books books) {
	this.books = books;
}


}
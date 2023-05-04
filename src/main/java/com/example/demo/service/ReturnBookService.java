package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.IssueBook;
import com.example.demo.entity.Librarian;
import com.example.demo.entity.ReturnBook;
import com.example.demo.entity.Students;


public interface ReturnBookService {
	public List<ReturnBook>findAllReturnBook();
	public ReturnBook addReturnbook(ReturnBook r);
	public ReturnBook getReturnBookById(int sId);
	public ReturnBook updateReturnBook(IssueBook r);
	public String deleteById(int sId);
	

}

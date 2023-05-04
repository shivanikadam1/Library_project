package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Books;
import com.example.demo.entity.IssueBook;
import com.example.demo.entity.ReturnBook;
import com.example.demo.entity.Students;

import com.example.demo.service.ReturnBookService;
@RestController
@RequestMapping("/return")
@CrossOrigin(origins = "http://localhost:4200")
public class ReturnBookController {
	@Autowired
	ReturnBookService service;
	@GetMapping("/list")
	public List<ReturnBook> findAllReturnBook() 
	{
		return service.findAllReturnBook();
	}
	
	@PostMapping("/addreturnbook")
	public ResponseEntity<ReturnBook> addReturnbook(@Valid @RequestBody ReturnBook r) {

		return new ResponseEntity<ReturnBook>(service.addReturnbook(r), HttpStatus.CREATED);
	}
	@GetMapping("find/{returnbookid}")
	public ResponseEntity<ReturnBook> getIssueBookById(@PathVariable("returnbookid") int returnbookid) {
		return new ResponseEntity<ReturnBook>(service.getReturnBookById(returnbookid), HttpStatus.OK);
	}
	@PutMapping("update/{returnbookid}")
	public ResponseEntity<ReturnBook> updateReturnBook(@Valid  @RequestBody IssueBook e) {
		return new ResponseEntity<ReturnBook>(service.updateReturnBook(e),HttpStatus.OK);
	}
	@DeleteMapping("delete/{returnbookid}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("issuebookid") int returnbookid) {
		service.deleteById(returnbookid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
	


}

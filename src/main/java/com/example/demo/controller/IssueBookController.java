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

import com.example.demo.entity.IssueBook;
import com.example.demo.service.IssueBookService;

@RestController
@RequestMapping("/issuebook")
@CrossOrigin(origins = "http://localhost:4200")
public class IssueBookController {
	@Autowired
	IssueBookService service;
	@GetMapping("/list")
	public List<IssueBook> getAllIssueBook() 
	{
		return service.findAllIssueBook();
	}
	@PostMapping("/addissuebook")
	public ResponseEntity<IssueBook> addIssueBook(@Valid @RequestBody IssueBook e) {

		return new ResponseEntity<IssueBook>(service.addIssueBook(e), HttpStatus.CREATED);
	}
	@GetMapping("find/{issuebookid}")
	public ResponseEntity<IssueBook> getIssueBookById(@PathVariable("issuebookid") int issuebookid) {
		return new ResponseEntity<IssueBook>(service.getIssueBookById(issuebookid), HttpStatus.OK);
	}
	@PutMapping("update/{issuebookid}")
	public ResponseEntity<IssueBook> updateEmployee(@Valid  @RequestBody IssueBook e) {
		return new ResponseEntity<IssueBook>(service.updateIssueBook(e),HttpStatus.OK);
	}
	@DeleteMapping("delete/{issuebookid}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("issuebookid") int issuebookid) {
		service.deleteById(issuebookid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}

}

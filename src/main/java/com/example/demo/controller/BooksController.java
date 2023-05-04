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
import com.example.demo.entity.Students;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:4200")

public class BooksController {
	@Autowired
	BookService service;
	@GetMapping("find/{bookid}")
	public ResponseEntity<Books> getBooksById(@PathVariable("bookid") int bookid) {
		return new ResponseEntity<Books>(service.getBooksById(bookid), HttpStatus.OK);
	}
	@PostMapping("/addbook")
	public ResponseEntity<Books> addBook(@Valid @RequestBody Books e) {

		return new ResponseEntity<Books>(service.addBook(e), HttpStatus.CREATED);
	}
	@GetMapping("/list")
	public List<Books> getAllBooks() 
	{
		return service.findAllBooks();
	}
	@PutMapping("update/{bookid}")
	public ResponseEntity<Books> updateBook(@Valid  @RequestBody Books e) {
		return new ResponseEntity<Books>(service.updateBooks(e),HttpStatus.OK);
	}
	@DeleteMapping("delete/{bookid}")
	public ResponseEntity<Boolean> deleteBook(@PathVariable("bookid") int bookid) {
		service.deleteById(bookid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}

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

import com.example.demo.dao.LibrarianDao;
import com.example.demo.entity.Librarian;
import com.example.demo.service.LibrarianService;

@RestController
@RequestMapping("/librarian")
@CrossOrigin(origins = "http://localhost:4200")
public class LibrarianController {
	@Autowired
	LibrarianService service;
	@Autowired
	private LibrarianDao dao2;
	@GetMapping("/list")
	public List<Librarian> getAllLibrarian() 
	{
		return service.findAllLibrarian();
	}
	@PostMapping("/addlibrarian")
	public ResponseEntity<Librarian> addLibrarian(@Valid @RequestBody Librarian l) {

		return new ResponseEntity<Librarian>(service.addLibrarian(l), HttpStatus.CREATED);
	}
	@GetMapping("find/{id}")
	public ResponseEntity<Librarian> getProductById(@PathVariable("id") int id) {
		return new ResponseEntity<Librarian>(service.getLibrarianById(id), HttpStatus.OK);
	}
	@PutMapping("update")
	public ResponseEntity<Librarian> updateEmployee(@Valid  @RequestBody Librarian l) {
		return new ResponseEntity<Librarian>(service.updateLibrarian(l),HttpStatus.OK);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Boolean> deleteLibrarian(@PathVariable("id") int id) {
		service.deleteById(id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Librarian librarianData) {
		Librarian  user = dao2.findByUsername(librarianData.getUsername());

		if (user.getPassword().equals(librarianData.getPassword())) {
			Librarian senduser=new Librarian();
			senduser.setId(user.getId());
			senduser.setName(user.getName());
			senduser.setAddress(user.getAddress());
			senduser.setContact(user.getContact());
			
			senduser.setUsername(user.getUsername());

			return ResponseEntity.ok(senduser);
		} else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}

}

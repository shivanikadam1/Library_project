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

import com.example.demo.entity.Students;
import com.example.demo.service.StudentsService;
@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentsController {
@Autowired
StudentsService service;
@GetMapping("/list")
public List<Students> getAllStudents() 
{
	return service.findAllStudent();
}

@PostMapping("/addstudent")
public ResponseEntity<Students> addStudent(@Valid @RequestBody Students e) {

	return new ResponseEntity<Students>(service.addStudent(e), HttpStatus.CREATED);
}

@GetMapping("find/{studentid}")
public ResponseEntity<Students> getStudentById(@PathVariable("studentid") int studentid) {
	return new ResponseEntity<Students>(service.getStudentById(studentid), HttpStatus.OK);
}
@PutMapping("update/{studentid}")
public ResponseEntity<Students> updateEmployee(@Valid  @RequestBody Students e) {
	return new ResponseEntity<Students>(service.updateStudent(e),HttpStatus.OK);
}
@DeleteMapping("delete/{studentid}")
public ResponseEntity<Boolean> deleteStudent(@PathVariable("studentid") int studentid) {
	service.deleteById(studentid);
	boolean flag = true;
	return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
}
}

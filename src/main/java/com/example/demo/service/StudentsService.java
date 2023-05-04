package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Students;

@Service
public interface StudentsService {
	public List<Students>findAllStudent();
	public Students addStudent(Students e);
	public Students getStudentById(int sId);
	public Students updateStudent(Students e);
	public String deleteById(int sId);


}

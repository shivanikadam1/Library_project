package com.example.demo;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.StudentsDao;
import com.example.demo.entity.Students;


@SpringBootTest
class LibraryManagementSystemProjectApplicationTests {
	private StudentsDao dao;

	@Test
	void contextLoads() {
	}
	@Test
	public void testCreate() throws ParseException
	{
		Scanner sc=new Scanner(System.in);
	

		Students s=new Students();
		System.out.println("enter the issue date");
		 String issue_date = sc.next();
	     //Converting String to Date
	     Date date = FormattingDate.StringToDate(issue_date);
	     System.out.println(date);
			System.out.println("enter the issue date");
			 String return_date = sc.next();
		     //Converting String to Date
		     Date date1 = FormattingDate.StringToDate(return_date);
		     System.out.println(date1);
	     //System.out.println(date);
			s.setsName("mayuri");
			s.setAddress("phaltan");
			s.setBranch("abc");
			dao.save(s);
		

	}}


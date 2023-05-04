package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.StudentsDao;
import com.example.demo.entity.Books;
import com.example.demo.entity.Students;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class StudentsServiceImpl implements StudentsService{
@Autowired
 StudentsDao dao;

@Override
public List<Students> findAllStudent() {
	// TODO Auto-generated method stub
	return dao.findAll();
}

@Override
public Students addStudent(Students e) {
	// TODO Auto-generated method stub
	Students existingemp=dao.findById(e.getsId()).orElse(null);
	   if(existingemp==null)
	    {
			e.setsName(e.getsName());
			e.setAddress(e.getAddress());
			e.setBranch(e.getBranch());
			e.setBookid(e.getBookid());
			e.setIssue_date(e.getIssue_date());
			e.setReturn_date(e.getReturn_date());
			
			return dao.save(e);
	}
	else
	{
		throw new ResourceNotFoundException("employee already exist");
	}

		}

@Override
public Students getStudentById(int sId) {
	// TODO Auto-generated method stub
	return this.dao.findById(sId).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + sId));
}

@Override
public Students updateStudent(Students e) {
	// TODO Auto-generated method stub
	Students existingStd=dao.findById(e.getsId()).orElseThrow(() -> new ResourceNotFoundException("student not exist with id :"));
	
	
	existingStd.setsName(e.getsName());
	existingStd.setAddress(e.getAddress());
	existingStd.setBranch(e.getBranch());
	existingStd.setBookid(e.getBookid());
	existingStd.setIssue_date(e.getIssue_date());
	existingStd.setReturn_date(e.getReturn_date());

	return dao.save(existingStd);
}


@Override
public String deleteById(int sId) {
	// TODO Auto-generated method stub
	Students existsID=dao.findById(sId).orElse(null);
	if(existsID!=null)
	{
	dao.deleteById(sId);
	return "Students deleted!!";
	}
	else
	{
	throw new ResourceNotFoundException("student id not available");

	}
}

}


	


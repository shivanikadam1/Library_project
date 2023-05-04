package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LibrarianDao;
import com.example.demo.dao.ReturnBookDao;
import com.example.demo.entity.IssueBook;
import com.example.demo.entity.Librarian;
import com.example.demo.entity.ReturnBook;
import com.example.demo.entity.Students;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class ReturnBookServiceImpl implements ReturnBookService {
	@Autowired
	ReturnBookDao dao;
	@Override
	public List<ReturnBook> findAllReturnBook() {
		// TODO Auto-generated method stub
		return  dao.findAll();
	}
	@Override
	public ReturnBook addReturnbook(ReturnBook r) {
		// TODO Auto-generated method stub
		ReturnBook existingemp=dao.findById(r.getsId()).orElse(null);
		   if(existingemp==null)
		    {
			    
				r.setsId(r.getsId());
				r.setsName(r.getsName());
				r.setBookid(r.getBookid());
				r.setReturn_date(r.getReturn_date());
				
				return dao.save(r);
		}
		else
		{
			throw new ResourceNotFoundException("already Returnbook ");
		}

	}
	@Override
	public ReturnBook getReturnBookById(int sId) {
		return this.dao.findById(sId).orElseThrow(() -> new ResourceNotFoundException("return book not exist with id :" + sId));
		
	}
	@Override
	public ReturnBook updateReturnBook(IssueBook r) {
		ReturnBook returnbook=dao.findById(r.getsId()).orElseThrow(() -> new ResourceNotFoundException("issue book not exist with id :"));
		
		
		returnbook.setsName(r.getsName());
		returnbook.setBookid(r.getBookid());
		returnbook.setBook_name(r.getBook_name());
		
		returnbook.setReturn_date(r.getReturn_date());
	

return dao.save(returnbook);
	}
	@Override
	public String deleteById(int sId) {
		ReturnBook returnbook=dao.findById(sId).orElse(null);
		if(returnbook!=null)
		{
		dao.deleteById(sId);
		return "issue book deleted!!";
		}
		else
		{
		throw new ResourceNotFoundException("return book book not available");

		}	}
	

}

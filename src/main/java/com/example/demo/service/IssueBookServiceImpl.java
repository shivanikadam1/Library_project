package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IssueBookDao;
import com.example.demo.entity.IssueBook;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class IssueBookServiceImpl implements IssueBookService {
@Autowired
IssueBookDao dao;
	@Override
	public List<IssueBook> findAllIssueBook() {
		return dao.findAll();
	}
	@Override
	public IssueBook addIssueBook(IssueBook e) {
		// TODO Auto-generated method stub
		IssueBook issuebook=dao.findById(e.getsId()).orElse(null);
		   if(issuebook==null)
		    {
				e.setsName(e.getsName());
				e.setBookid(e.getBookid());
				e.setBook_name(e.getBook_name());
				e.setIssue_date(e.getIssue_date());
				e.setReturn_date(e.getReturn_date());
				e.setQuantity(e.getQuantity());
				
				return dao.save(e);
		}
		else
		{
			throw new ResourceNotFoundException("issue book already exist");
		}

			}
	
	@Override
	public IssueBook getIssueBookById(int sId) {
		// TODO Auto-generated method stub
		return this.dao.findById(sId).orElseThrow(() -> new ResourceNotFoundException("issue book not exist with id :" + sId));
	}
	@Override
	public IssueBook updateIssueBook(IssueBook e) {
		// TODO Auto-generated method stub
		IssueBook issuebook=dao.findById(e.getsId()).orElseThrow(() -> new ResourceNotFoundException("issue book not exist with id :"));
		
		
				issuebook.setsName(e.getsName());
				issuebook.setBookid(e.getBookid());
                 issuebook.setBook_name(e.getBook_name());
		          issuebook.setIssue_date(e.getIssue_date());
		          issuebook.setReturn_date(e.getReturn_date());
		         issuebook.setQuantity(e.getQuantity());
		
		return dao.save(issuebook);
	}	
	@Override
	public String deleteById(int sId) {
		// TODO Auto-generated method stub
		IssueBook issuebook=dao.findById(sId).orElse(null);
		if(issuebook!=null)
		{
		dao.deleteById(sId);
		return "issue book deleted!!";
		}
		else
		{
		throw new ResourceNotFoundException("issue book not available");

		}	}

}

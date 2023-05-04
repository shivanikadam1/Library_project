package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BooksDao;
import com.example.demo.entity.Books;
import com.example.demo.entity.Students;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class BookServiceImpl implements BookService {
@Autowired
BooksDao dao;
	@Override
	public Books getBooksById(int id) {
		return this.dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("book not exist with id :" + id));
	}
	@Override
	public Books addBook(Books e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Books existingbook=dao.findById(e.getId()).orElse(null);
		   if(existingbook==null)
		    {
				e.setBook_name(e.getBook_name());
				e.setAuthorname(e.getAuthorname());
				e.setQuantity(e.getQuantity());
				e.setPrice(e.getPrice());
				return dao.save(e);
		}
		else
		{
			throw new ResourceNotFoundException("book already exist");
		}

			}
	@Override
	public List<Books> findAllBooks() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public Books updateBooks(Books e) {
		// TODO Auto-generated method stub
		Books existingbook=dao.findById(e.getId()).orElseThrow(() -> new ResourceNotFoundException("book not exist with id :"));
		
		
		existingbook.setBook_name(e.getBook_name());
		existingbook.setAuthorname(e.getAuthorname());
		existingbook.setQuantity(e.getQuantity());
		existingbook.setPrice(e.getPrice());

		return dao.save(existingbook);
	}
	
	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Books existsID=dao.findById(id).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(id);
		return "book deleted!!";
		}
		else
		{
		throw new ResourceNotFoundException("book id not available");

		}	}
	
	

}

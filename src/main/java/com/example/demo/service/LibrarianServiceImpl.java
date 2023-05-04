package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LibrarianDao;

import com.example.demo.entity.Librarian;
@Service
public class LibrarianServiceImpl implements LibrarianService {
	@Autowired
	LibrarianDao dao;
	@Override
	public List<Librarian> findAllLibrarian() {
		// TODO Auto-generated method stub
		return  dao.findAll();
	}

	@Override
	public Librarian addLibrarian(Librarian l) {
		Librarian existinglibrarian=dao.findById(l.getId()).orElse(null);
		   if(existinglibrarian==null)
		    {
				l.setName(l.getName());
				l.setEmail(l.getEmail());
				l.setAddress(l.getAddress());
				
				l.setContact(l.getContact());
				
				
				return dao.save(l);
		}
		else
		{
			throw new ResourceNotFoundException("Librarian Details already exist");
		}

	}

	@Override
	public Librarian getLibrarianById(int id) {
		return this.dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Librarian Details not exist with id :" + id));
		
	}

	@Override
	public Librarian updateLibrarian(Librarian l) {
		Librarian existinglibrarian=dao.findById(l.getId()).orElseThrow(() -> new ResourceNotFoundException("librarian details not exist with id :"));
		 existinglibrarian.setName(l.getName());
		 existinglibrarian.setEmail(l.getEmail());
		 existinglibrarian.setAddress(l.getAddress());
		 
		 existinglibrarian.setContact(l.getContact());
		
		return dao.save(existinglibrarian);
	}

	@Override
	public String deleteById(int id) {
		Librarian existsID=dao.findById(id).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(id);
		return "Librarian Details deleted!!";
		}
		else
		{
		throw new ResourceNotFoundException("Librarian id not available");

		}
	}

	@Override
	public ResponseEntity<?> loginLibrarian(Librarian librarianData) {
		Librarian user = dao.findByUsername(librarianData.getUsername());

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

	@Override
	public Librarian findByUsername(String name) {
		return dao.findByUsername(name) ;
		
	}
	}



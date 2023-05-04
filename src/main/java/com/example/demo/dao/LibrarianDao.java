package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Librarian;

@Repository
public interface LibrarianDao extends JpaRepository<Librarian, Integer> {
	public Librarian findByUsername(String librarian_username);

}

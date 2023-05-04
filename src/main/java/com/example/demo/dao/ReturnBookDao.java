package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ReturnBook;


@Repository
public interface ReturnBookDao extends JpaRepository<ReturnBook, Integer>{

}

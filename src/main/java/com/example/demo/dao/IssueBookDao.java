package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.IssueBook;


@Repository

public interface IssueBookDao extends JpaRepository<IssueBook, Integer>{

}

package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.IssueBook;

@Service
public interface IssueBookService {
	public List<IssueBook>findAllIssueBook();
	public IssueBook addIssueBook(IssueBook e);
	public IssueBook getIssueBookById(int sId);
	public IssueBook updateIssueBook(IssueBook e);
	public String deleteById(int sId);

}

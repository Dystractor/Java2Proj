package com.example.springproject.service;

import com.example.springproject.api.IssuesRepository;

import com.example.springproject.Entity.Issues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssuesServiceImpl implements IssuesService{
    @Autowired
    private IssuesRepository issuesRepository;
    @Override
    public void save(Issues issues) {
        issuesRepository.save(issues);
    }
}

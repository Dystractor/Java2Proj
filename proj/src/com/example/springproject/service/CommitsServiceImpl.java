package com.example.springproject.service;

import com.example.springproject.api.CommitsRepository;

import com.example.springproject.Entity.Commits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitsServiceImpl implements CommitsService{
    @Autowired
    private CommitsRepository commitsRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Commits commits) {
        commitsRepository.save(commits);
    }






}

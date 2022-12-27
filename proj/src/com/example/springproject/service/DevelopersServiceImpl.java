package com.example.springproject.service;

import com.example.springproject.api.DevelopersRepository;

import com.example.springproject.Entity.Developers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevelopersServiceImpl implements DevelopersService{
    @Autowired
    private DevelopersRepository developersRepository;
    @Override
    public void save(Developers developers) {
        developersRepository.save(developers);
    }

    @Override
    public Developers findByUsername(String username) {
        return developersRepository.findUserByUsername(username);
    }
}

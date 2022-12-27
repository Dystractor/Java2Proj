package com.example.springproject.service;

import com.example.springproject.Entity.Developers;

public interface DevelopersService {
    public Developers findByUsername(String username);
    public void save(Developers developers);
}

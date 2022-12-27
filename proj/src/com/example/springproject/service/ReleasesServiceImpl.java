package com.example.springproject.service;

import com.example.springproject.api.ReleasesRepository;

import com.example.springproject.Entity.Releases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleasesServiceImpl implements ReleasesService{
    @Autowired
    private ReleasesRepository releasesRepository;
    @Override
    public void save(Releases releases) {
        releasesRepository.save(releases);
    }
}

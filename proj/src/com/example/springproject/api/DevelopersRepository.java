package com.example.springproject.api;

import com.example.springproject.Entity.Developers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DevelopersRepository  extends JpaRepository<Developers, Integer> {
//    @Query("select COUNT(id) from developers")
//    List<Developers> countDevelopersById();
//
//    @Query("select user_id,username from developers,commits where ")

    public Developers findUserByUsername(String username);



}

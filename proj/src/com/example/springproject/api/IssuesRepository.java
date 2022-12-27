package com.example.springproject.api;

import com.example.springproject.Entity.Issues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuesRepository  extends JpaRepository<Issues, Integer> {

}

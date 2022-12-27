package com.example.springproject.api;

import com.example.springproject.Entity.Commits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitsRepository  extends JpaRepository<Commits, Integer> {



}

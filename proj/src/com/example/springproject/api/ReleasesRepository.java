package com.example.springproject.api;

import com.example.springproject.Entity.Releases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleasesRepository  extends JpaRepository<Releases, Integer> {

}

package com.greetingapp.repository;

import com.greetingapp.model.Greetings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//UC4
@Repository
public interface GreetingRepository extends JpaRepository<Greetings,Long>{}

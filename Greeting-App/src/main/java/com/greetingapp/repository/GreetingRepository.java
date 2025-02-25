package com.greetingapp.repository;

import com.greetingapp.model.Greetings;
import org.springframework.data.jpa.repository.JpaRepository;
//UC4
public interface GreetingRepository extends JpaRepository<Greetings,Long>{}

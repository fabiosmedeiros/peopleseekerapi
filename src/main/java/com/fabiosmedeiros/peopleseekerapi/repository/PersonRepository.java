package com.fabiosmedeiros.peopleseekerapi.repository;

import com.fabiosmedeiros.peopleseekerapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

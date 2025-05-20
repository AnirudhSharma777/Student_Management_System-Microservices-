package com.school.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.Entities.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, String>{
    School findByName(String name);
}

package com.jpatutorial.jpaentity.repository;

import com.jpatutorial.jpaentity.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}

package com.jpatutorial.jpaentity.repository;

import com.jpatutorial.jpaentity.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByName(String name);

    @Transactional
    @Modifying
    @Query(value = "SELECT setval('course_id_seq', (SELECT MAX(id) FROM course))", nativeQuery = true)
    int resetSequence();

    @Transactional
    void deleteByIdIn(List<Long> ids);
}

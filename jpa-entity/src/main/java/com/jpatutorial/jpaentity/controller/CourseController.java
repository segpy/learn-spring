package com.jpatutorial.jpaentity.controller;

import com.jpatutorial.jpaentity.model.Course;
import com.jpatutorial.jpaentity.repository.CourseRepository;
import com.jpatutorial.jpaentity.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @PostMapping("/course")
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable(value = "id") Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        return course.orElse(null);
    }

    @GetMapping("/course/name/{name}")
    public Course getCourseByName(@PathVariable(value = "name") String courseName) {
        return courseRepository.findByName(courseName);
    }

    @DeleteMapping("/course/{id}")
    public String deleteCourse(@PathVariable(value = "id") List<Long> courseId) {
        try {
            courseService.deleteByIdIn(courseId);
            return "Deleted";
        } catch (Exception e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    @GetMapping("/course/sequence")
    public int restoreSequence() {
        return courseRepository.resetSequence();
    }

}

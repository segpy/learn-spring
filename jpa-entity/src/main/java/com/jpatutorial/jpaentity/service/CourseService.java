package com.jpatutorial.jpaentity.service;

import com.jpatutorial.jpaentity.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public void resetSequence() {
        courseRepository.resetSequence();
    }

    @Transactional
    public void deleteByIds(Iterable<Long> ids) {
        courseRepository.deleteAllById(ids);
        resetSequence();
    }

    public void deleteByIdIn(List<Long> ids) {
        courseRepository.deleteByIdIn(ids);
    }
}

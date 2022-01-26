package com.demo.services;

import com.demo.models.Course;
import com.demo.repositories.CourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    private static ObjectMapper mapper = new ObjectMapper();

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public void create(Course course) {
       courseRepository.save(course);
    }
}


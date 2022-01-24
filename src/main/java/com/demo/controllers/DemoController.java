package com.demo.controllers;

import com.demo.configurations.PropertiesConfiguration;
import com.demo.dto.CourseRequestDto;
import com.demo.models.Course;
import com.demo.services.CourseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/courses")
public class DemoController {

    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    @Value("${default.course.name}")
    String defaultCourseName;

    @Autowired
    CourseService courseService;

    private static final Logger LOGGER = LogManager.getLogger(DemoController.class);

    @GetMapping(value = "/{courseId}")
    private Course getCourseById(@RequestParam(defaultValue = "true") Boolean showDefault, @PathVariable int courseId) {
        LOGGER.info("Request received");
        String courseName = showDefault ? defaultCourseName : propertiesConfiguration.getName();
        LOGGER.info("Request Completed");
        return new Course(courseName, courseId);
    }

    @GetMapping(value = "/all")
    @ResponseBody
    private List<Course> getAll() {
        return courseService.getAll();
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    private void createCourse(@Valid @RequestBody CourseRequestDto request) {
        courseService.create(request.converter());
    }
}

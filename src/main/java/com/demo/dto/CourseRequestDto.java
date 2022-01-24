package com.demo.dto;

import com.demo.models.Course;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class CourseRequestDto {
    @NotNull
    int id;

    @NotBlank(message = "Not valid")
    String name;

    public Course converter() {
        return new Course(name, id);
    }
}

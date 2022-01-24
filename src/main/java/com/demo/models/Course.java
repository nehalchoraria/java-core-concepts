package com.demo.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Course")
public class Course extends Key {

    String name;
    int courseId;

    public Course(String name, int courseId) {
        this.name = name;
        this.courseId = courseId;
    }

    public Course() {}
}

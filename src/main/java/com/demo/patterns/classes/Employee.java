package com.demo.patterns.classes;

import lombok.Data;

@Data
public class Employee {
    public String name;
    public int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

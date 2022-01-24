package com.demo.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Key {

    @Id @GeneratedValue
    private int id;
}

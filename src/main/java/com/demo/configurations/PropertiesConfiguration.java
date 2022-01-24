package com.demo.configurations;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "course")
@Getter @Setter
public class PropertiesConfiguration {

    String name;
    int id;
}

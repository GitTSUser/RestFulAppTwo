package com.ford.demo.restfulapptwo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int id;
    private String name;
    private double fee;
    private int duration;

}

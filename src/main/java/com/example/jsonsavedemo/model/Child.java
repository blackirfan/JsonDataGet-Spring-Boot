package com.example.jsonsavedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Child implements Serializable {
    private String name;
    private String age;
    private String color;

}
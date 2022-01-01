package com.example.jsonsavedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bio implements Serializable {
    private String text;
    private String comment;
    private String point;

}
package com.example.jsonsavedemo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BioUpdate {
    private Integer id;
    private String text;
    private String comment;
}

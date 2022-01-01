package com.example.jsonsavedemo.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse
{
    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
        this.success = false;
    }

    //General error message about nature of error
    private String message;

    private Boolean success;

    //Specific errors in API request processing
    private List<String> details;

    //Getter and setters
}

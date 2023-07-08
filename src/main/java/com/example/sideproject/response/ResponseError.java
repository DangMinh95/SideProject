package com.example.sideproject.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class ResponseError {

    @Getter
    @Setter
    private Integer errorCode;

    @Getter
    @Setter
    private String message;

}

package com.example.sideproject.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseSuccess {

    @Getter
    @Setter
    private Integer status;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private Object data;

    public ResponseSuccess(Integer status, String message){
        this.status = status;
        this.message = message;
    };
}

package com.example.capstone2.ApiResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}

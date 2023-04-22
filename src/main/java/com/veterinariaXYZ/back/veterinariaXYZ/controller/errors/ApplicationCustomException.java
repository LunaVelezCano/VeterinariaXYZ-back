package com.veterinariaXYZ.back.veterinariaXYZ.controller.errors;

import com.veterinariaXYZ.back.veterinariaXYZ.util.ResponseMessage;

public class ApplicationCustomException extends Exception{

    private int code;
    private final String message;


    public ApplicationCustomException(int entityAlreadyExistsCode, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public ResponseMessage<Object> getResponse(){
        return new ResponseMessage<>(this.code, this.message, null);
    }


}

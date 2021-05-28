package com.bgouk.hrmsproject.core.utils.result;

import lombok.Getter;

@Getter
public class Result {
    public Result(boolean success) {
        this.success = success;

    }

    public Result(boolean success, String message){
        this(success);
        this.message = message;
    }


    private final boolean success;
    private String message;


}

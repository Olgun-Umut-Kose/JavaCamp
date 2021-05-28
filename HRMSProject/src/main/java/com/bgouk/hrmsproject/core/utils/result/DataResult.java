package com.bgouk.hrmsproject.core.utils.result;

import lombok.Getter;

@Getter
public class DataResult<T> extends Result {
    public DataResult(T data,boolean success) {
        super(success);
        this.data = data;
    }

    public DataResult(T data,boolean success, String message) {

        super(success, message);
        this.data = data;

    }
    private final T data;
}

package com.bgouk.hrmsproject.core.utils.result;

public class ErrorResult extends Result{
    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(false, message);
    }
}

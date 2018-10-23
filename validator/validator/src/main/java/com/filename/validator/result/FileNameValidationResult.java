package com.filename.validator.result;

public class FileNameValidationResult{
    private String message;
    private String status ;

    public FileNameValidationResult(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String toString() {
        return this.message;
    }

    public String getMessage() {
        return this.message;
    }
    public String getStatus() {
        return this.status;
    }
}


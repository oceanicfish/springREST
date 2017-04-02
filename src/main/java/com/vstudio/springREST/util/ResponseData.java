package com.vstudio.springREST.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by yang on 02/04/2017.
 */
@JsonAutoDetect
public class ResponseData {

    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

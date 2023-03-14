package com.gcp.exception;

public class GoogleCloudException extends Exception{
    public GoogleCloudException() {
    }

    public GoogleCloudException(String message) {
        super(message);
    }

    public GoogleCloudException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoogleCloudException(Throwable cause) {
        super(cause);
    }

    public GoogleCloudException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

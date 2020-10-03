package com.github.freeygo.engine.event;

/**
 * @author 戴志勇
 */
public class NoEventSubjectException extends RuntimeException {


    public NoEventSubjectException() {
    }

    public NoEventSubjectException(String message) {
        super(message);
    }

    public NoEventSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoEventSubjectException(Throwable cause) {
        super(cause);
    }

    public NoEventSubjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}

package io.jsoncraft.objects;

public class ObjectsException extends RuntimeException {

    public ObjectsException() {
    }

    public ObjectsException(String message) {
        super(message);
    }

    public ObjectsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectsException(Throwable cause) {
        super(cause);
    }

    public ObjectsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

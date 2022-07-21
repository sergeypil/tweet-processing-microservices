package net.serg.exception;

public class TwitterToKafkaException extends RuntimeException {

    public TwitterToKafkaException() {
        super();
    }

    public TwitterToKafkaException(String message) {
        super(message);
    }

    public TwitterToKafkaException(String message, Throwable cause) {
        super(message, cause);
    }
}

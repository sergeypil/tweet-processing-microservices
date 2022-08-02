package net.serg.elasticsearch.exception;

public class ElasticsearchQueryClientException extends RuntimeException {

    public ElasticsearchQueryClientException() {
        super();
    }

    public ElasticsearchQueryClientException(String message) {
        super(message);
    }

    public ElasticsearchQueryClientException(String message, Throwable t) {
        super(message, t);

    }
}
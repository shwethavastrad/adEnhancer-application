package com.svastrad.adEnhancer.error;

public class PublisherNotFoundException extends RuntimeException {
    private String page;
    public PublisherNotFoundException() {
        super();
    }

    public PublisherNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PublisherNotFoundException(final String message) {
        super(message);
    }
    public PublisherNotFoundException(final String message, String page) {
        super(message);
        this.page = page;
    }


    public PublisherNotFoundException(final Throwable cause) {
        super(cause);
    }
}

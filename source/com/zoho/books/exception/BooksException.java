/* $Id$ */

package com.zoho.books.exception;

/**
 * BooksException is used to throws a new books exception.
 */

public class BooksException extends Exception {

    private int code;

    private String message;


    /**
     * Construct a new BooksException by passing an error code and error message.
     *
     * @param code    Error code.
     * @param message Error message.
     */

    public BooksException(int code, String message) {

        super(message);

        this.code = code;

        this.message = message;

    }


    /**
     * get the error code.
     *
     * @return Returns the error code.
     */

    public int getCode() {
        return code;
    }

    /**
     * get the error message.
     *
     * @return Returns the error message.
     */

    public String getMessage() {
        return message;
    }
}

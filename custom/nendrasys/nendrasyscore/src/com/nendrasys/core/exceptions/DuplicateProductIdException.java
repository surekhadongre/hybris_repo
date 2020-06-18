package com.nendrasys.core.exceptions;

public class DuplicateProductIdException extends Exception {


    /**
     * Default constructor
     */
    public DuplicateProductIdException()
    {
        super();
    }

    /**
     * @param message
     * @param cause
     */
    public DuplicateProductIdException(final String message, final Throwable cause)
    {
        super(message, cause);
    }

    /**
     * @param message
     */
    public DuplicateProductIdException(final String message)
    {
        super(message);
    }

    /**
     * @param cause
     */
    public DuplicateProductIdException(final Throwable cause)
    {
        super(cause);
    }
}

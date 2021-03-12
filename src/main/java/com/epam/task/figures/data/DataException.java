package com.epam.task.figures.data;

public class DataException extends Exception{
    public DataException(final String message, Throwable cause) {
        super(message, cause);
    }
    public DataException( String message) {
        super(message);
    }
}

package com.agropix.ada.exceptions;

public class ItemNotExistsException extends RuntimeException{

    public ItemNotExistsException(String message) {
        super(message);
    }
}

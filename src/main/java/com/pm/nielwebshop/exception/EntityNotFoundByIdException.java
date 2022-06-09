package com.pm.nielwebshop.exception;

import java.util.NoSuchElementException;

public class EntityNotFoundByIdException extends NoSuchElementException {

    public EntityNotFoundByIdException(String entity, Long id) {
        super(String.format("%s with id %d was not found.", entity, id));
    }
}

package com.pm.nielwebshop.exception;

import java.util.Collections;
import java.util.List;

public class ValidationRestErrorMessage extends RestErrorMessage{

    private List<String> validationMessages;

    public ValidationRestErrorMessage(String message, Integer code, List<String> validationMessages) {
        super(message, code);
        this.validationMessages = validationMessages;
    }

    public void setValidationMessages(List<String> validationMessages) {
        this.validationMessages = validationMessages;
    }

    public void addValidationMessage(String message) {
        this.validationMessages.add(message);
    }

    public List<String> getValidationMessages() {
        return Collections.unmodifiableList(validationMessages);
    }
}

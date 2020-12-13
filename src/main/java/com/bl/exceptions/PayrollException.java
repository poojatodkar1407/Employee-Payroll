package com.bl.exceptions;

public class PayrollException extends RuntimeException {

    public ExceptionTypes exceptionTypes;

    public PayrollException(ExceptionTypes exceptionTypes){
        this.exceptionTypes = exceptionTypes;
    }

    public enum ExceptionTypes{
        EMPLOYEE_NOT_FOUND("Invalid Data.. Employee not found"),
        EMPLOYEE_ALREDY_PRESENT("Employee Already Present"),
        OTHER_EXCEPTION("other exceptions");
        public String errorMessage;

        ExceptionTypes(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

}

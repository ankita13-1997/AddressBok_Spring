package com.example.address_book.exception;

public class AddressBookException extends RuntimeException{

    public ExceptionTypes exceptionTypes;

    public AddressBookException(ExceptionTypes exceptionTypes){
        this.exceptionTypes=exceptionTypes;
    }



    public enum ExceptionTypes {
        LOG_ALREADY_PRESENT("log Already present"),
        LOG_NOT_FOUND("log not found"),
        INVALID_LOG_ID("log id you have given is incorrect"),
        LOG_NOT_PRESENT("log is not present in database")
        ;
        public String errorMsg;
        ExceptionTypes(String errorMsg){
            this.errorMsg =errorMsg;
        }



    }

}

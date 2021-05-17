package com.example.address_book.exception;

import com.example.address_book.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class AddressBookGlobalExceptionHandler {
    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ResponseDto> handleAddressBookException(AddressBookException addressBookException){
        log.error("Exception Occurred : " +addressBookException.exceptionTypes.errorMsg);

        return new ResponseEntity<ResponseDto>(new ResponseDto(addressBookException.exceptionTypes.errorMsg,
                                                              null,null),
                                                                HttpStatus.BAD_REQUEST);
    }

}

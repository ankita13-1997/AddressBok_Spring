package com.example.address_book.dto;

import lombok.Data;

@Data
public class ResponseDto {

        private String message;
        private String statusCode;
        private Object object;

        public ResponseDto(String message, String statusCode, Object object) {
            this.message = message;
            this.statusCode = statusCode;
            this.object = object;
        }
}

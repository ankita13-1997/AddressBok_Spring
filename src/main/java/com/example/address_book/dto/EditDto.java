package com.example.address_book.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class EditDto extends AddressBookDTO{

    private UUID addressBookId;

    public EditDto(String firstName, String lastName,
                   String phoneNumber, String address,
                   String city, String state, String zipCode) {

        super(firstName, lastName, phoneNumber, address, city, state, zipCode);
    }
}

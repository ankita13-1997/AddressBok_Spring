package com.example.address_book.dto;

import com.example.address_book.model.AddressBookModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {

    @Pattern(regexp = "[A-Z]{1}[a-z]{3,20}$",message = "Please Do Enter Valid First Name!")
    @NotNull(message = "Please Do Enter valid name!")
    @NotEmpty(message = "Please Enter Valid name!")
    private String firstName;

    @Pattern(regexp = "[A-Z]{1}[a-z]{3,20}$",message = "Please Do Enter Valid Last Name!")
    @NotNull(message = "Please Do Enter valid last name!")
    @NotEmpty(message = "Please Enter Valid last name!")
    private String lastName;

    @NotNull(message = "Please Do Enter Valid Mobile Number!")
    @NotEmpty(message = "Please Do Enter Valid Mobile Number!")
    @Pattern(regexp = "^[9]{1}[1]{1}[7896]{1}[0-9]{9}$", message = "Please Do Enter Valid Mobile Number!")
    private String phoneNumber;

    @Pattern(regexp = "^[A-Za-z-,/.0-9]{3,}$",message = "Please Do Enter Valid Address!")
    @NotNull(message = "Please Do Enter Address!")
    @NotEmpty(message = "Please Enter Address!")
    private String address;

    @NotNull(message = "Please Do Enter city!")
    @NotEmpty(message = "Please Enter city!")
    private String city;

    @NotNull(message = "Please Do Enter state!")
    @NotEmpty(message = "Please Enter state!")
    private String state;

    @Pattern(regexp = "^[0-9]{6,10}(?:-[0-9]{4})?$",message = "please enter valid zip code")
    @NotNull(message = "Please Do Enter zipcode!")
    @NotEmpty(message = "Please Enter zipcode!")
    private String zipCode;

    public AddressBookDTO(String firstName, String lastName, String phoneNumber, String address, String city, String state, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public AddressBookDTO(AddressBookModel addressBook) {

        this.firstName   = addressBook.getFirstName();
        this.lastName    = addressBook.getLastName();
        this.phoneNumber = addressBook.getPhoneNumber();
        this.address     = addressBook.getAddress();
        this.city        = addressBook.getCity();
        this.state       = addressBook.getState();
        this.zipCode     = addressBook.getZipCode();
    }
}

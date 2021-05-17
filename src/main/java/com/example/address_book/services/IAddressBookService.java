package com.example.address_book.services;

import com.example.address_book.dto.AddressBookDTO;
import com.example.address_book.dto.EditDto;
import com.example.address_book.model.AddressBookModel;

import java.util.List;
import java.util.UUID;

public interface IAddressBookService {
    AddressBookDTO addUserDto(AddressBookDTO addressBook);
    AddressBookModel addUserModel(AddressBookDTO addressBook);


    AddressBookDTO findUserInDto(UUID addressBookId);
    AddressBookModel findUserInModel(UUID addressBookId);

    List<AddressBookDTO> findAllUsersDto();
    List<AddressBookModel> findAllUsersModel();

    AddressBookDTO deleteUserByIdInDto(UUID addressId);
    AddressBookModel deleteUserByIdInModel(UUID addressId);

    AddressBookDTO updateInDto(EditDto log);
    AddressBookModel updateInModel(EditDto log);
}

package com.example.address_book.services;

import com.example.address_book.dto.AddressBookDTO;
import com.example.address_book.dto.EditDto;
import com.example.address_book.exception.AddressBookException;
import com.example.address_book.model.AddressBookModel;
import com.example.address_book.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressBookService implements IAddressBookService{

    @Autowired
    AddressBookRepository addressBookRepository;


    @Override
    public AddressBookDTO addUserDto(AddressBookDTO addressBook) {
        Optional<AddressBookModel> byPhoneNumber =addressBookRepository.
                                                  findByPhoneNumber(addressBook.getPhoneNumber());
        if (byPhoneNumber.isPresent()){
            throw new AddressBookException(AddressBookException.ExceptionTypes.LOG_ALREADY_PRESENT);
        }

        AddressBookModel addressBookModel = new AddressBookModel(addressBook.getFirstName(),
                                                                 addressBook.getLastName(),
                                                                 addressBook.getPhoneNumber(),
                                                                 addressBook.getAddress(),
                                                                 addressBook.getCity(),
                                                                 addressBook.getState(),
                                                                 addressBook.getZipCode());
        return new AddressBookDTO(addressBookRepository.save(addressBookModel));
    }

    @Override
    public AddressBookModel addUserModel(AddressBookDTO addressBook) {
        Optional<AddressBookModel> byPhoneNumber =addressBookRepository.
                                                  findByPhoneNumber(addressBook.getPhoneNumber());
        if (byPhoneNumber.isPresent()){
            throw new AddressBookException(AddressBookException.ExceptionTypes.LOG_ALREADY_PRESENT);
        }
        AddressBookModel addressBookModel = new AddressBookModel(addressBook.getFirstName(),
                addressBook.getLastName(),
                addressBook.getPhoneNumber(),
                addressBook.getAddress(),
                addressBook.getCity(),
                addressBook.getState(),
                addressBook.getZipCode());
        return new AddressBookModel(addressBookRepository.save(addressBookModel));
    }

    @Override
    public AddressBookDTO findUserInDto(UUID addressBookId) {
        Optional<AddressBookModel> byId = addressBookRepository.findById(addressBookId);

        if (!byId.isPresent()){
            throw new AddressBookException(AddressBookException.ExceptionTypes.INVALID_LOG_ID);
        }


        return new AddressBookDTO(byId.get());
    }

    @Override
    public AddressBookModel findUserInModel(UUID addressBookId) {

        Optional<AddressBookModel> byId = addressBookRepository.findById(addressBookId);

        if (!byId.isPresent()){
            throw new AddressBookException(AddressBookException.ExceptionTypes.INVALID_LOG_ID);
        }
        return new AddressBookModel(byId.get());
    }

    @Override
    public List<AddressBookDTO> findAllUsersDto() {
        return addressBookRepository.findAll().stream().
                map(addressBookModel -> new AddressBookDTO(addressBookModel)).
                collect(Collectors.toList());
    }

    @Override
    public List<AddressBookModel> findAllUsersModel() {
        return addressBookRepository.findAll().stream().
                map(addressBookModel -> new AddressBookModel(addressBookModel)).
                collect(Collectors.toList());
    }

    @Override
    public AddressBookDTO deleteUserByIdInDto(UUID addressId) {
        Optional<AddressBookModel> byId = addressBookRepository.findById(addressId);

        if (!byId.isPresent()){
            throw new AddressBookException(AddressBookException.ExceptionTypes.LOG_NOT_FOUND);
        }
        addressBookRepository.deleteById(byId.get().getAddressBookId());
        return new AddressBookDTO(byId.get());

    }

    @Override
    public AddressBookModel deleteUserByIdInModel(UUID addressId) {
        Optional<AddressBookModel> byId = addressBookRepository.findById(addressId);

        if (!byId.isPresent()){
            throw new AddressBookException(AddressBookException.ExceptionTypes.LOG_NOT_FOUND);
        }
        addressBookRepository.deleteById(byId.get().getAddressBookId());
        return new AddressBookModel(byId.get());
    }

    @Override
    public AddressBookDTO updateInDto(EditDto log) {
        Optional<AddressBookModel> byId = addressBookRepository.findById(log.getAddressBookId());

        if (!byId.isPresent()){
            throw new AddressBookException(AddressBookException.ExceptionTypes.LOG_NOT_PRESENT);
        }

        byId.get().setAddressBookId(log.getAddressBookId());
        byId.get().setFirstName(log.getFirstName());
        byId.get().setLastName(log.getLastName());
        byId.get().setPhoneNumber(log.getPhoneNumber());
        byId.get().setAddress(log.getAddress());
        byId.get().setCity(log.getCity());
        byId.get().setState(log.getState());
        byId.get().setUpdatedAt(LocalDateTime.now());
        return new AddressBookDTO(addressBookRepository.save(byId.get()));
    }

    @Override
    public AddressBookModel updateInModel(EditDto log) {
        Optional<AddressBookModel> byId = addressBookRepository.findById(log.getAddressBookId());

        if (!byId.isPresent()){
            throw new AddressBookException(AddressBookException.ExceptionTypes.LOG_NOT_PRESENT);
        }
        byId.get().setAddressBookId(log.getAddressBookId());
        byId.get().setFirstName(log.getFirstName());
        byId.get().setLastName(log.getLastName());
        byId.get().setPhoneNumber(log.getPhoneNumber());
        byId.get().setAddress(log.getAddress());
        byId.get().setCity(log.getCity());
        byId.get().setState(log.getState());
        byId.get().setUpdatedAt(LocalDateTime.now());
        return new AddressBookModel(addressBookRepository.save(byId.get()));
    }


}

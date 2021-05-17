package com.example.address_book.controller;

import com.example.address_book.dto.AddressBookDTO;
import com.example.address_book.dto.EditDto;
import com.example.address_book.dto.ResponseDto;
import com.example.address_book.model.AddressBookModel;
import com.example.address_book.services.AddressBookService;
import com.example.address_book.services.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/addressbook-service")
public class AddressBookController {

    @Autowired
    IAddressBookService addressBookService = new AddressBookService();



    @PostMapping("/addbydto")
    public ResponseEntity<ResponseDto> addUserDto(@RequestBody @Valid AddressBookDTO addressBook,
                                                  BindingResult bindingResult){
        if(bindingResult.hasErrors()){
              return new ResponseEntity<ResponseDto>(new ResponseDto(bindingResult.getAllErrors().
                                                     get(0).getDefaultMessage(),"101",null),
                                                     HttpStatus.BAD_REQUEST);
        }

       AddressBookDTO addressBookDTO = addressBookService.addUserDto(addressBook);

        return new ResponseEntity<ResponseDto>(new ResponseDto("Address added successfully of : ",
                                                "200",addressBookDTO),HttpStatus.CREATED);


    }

    @PostMapping("/addbymodel")
    public ResponseEntity<ResponseDto> addUserModel(@RequestBody @Valid AddressBookDTO addressBook,
                                                  BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<ResponseDto>(new ResponseDto(bindingResult.getAllErrors().
                    get(0).getDefaultMessage(),"101",null),
                    HttpStatus.BAD_REQUEST);
        }

        AddressBookModel addressBookModel = addressBookService.addUserModel(addressBook);

        return new ResponseEntity<ResponseDto>(new ResponseDto("Address added successfully of : ",
                "200",addressBookModel),HttpStatus.CREATED);


    }


    @GetMapping("/getuserdto")
    public ResponseEntity<ResponseDto> findAnUserInDto(@RequestParam(value = "addressBookId")
                                                                          UUID addressBookId){
        AddressBookDTO addressBookDTO = addressBookService.findUserInDto(addressBookId);

        return new ResponseEntity<ResponseDto>(new ResponseDto("The log You are looking for is :",
                                                                "200",addressBookDTO),
                                                                 HttpStatus.CREATED);


    }

    @GetMapping("/getusermodel")
    public ResponseEntity<ResponseDto> findAnUserInModel(@RequestParam(value = "addressBookId")
                                                               UUID addressBookId){
        AddressBookModel addressBookModel = addressBookService.findUserInModel(addressBookId);

        return new ResponseEntity<ResponseDto>(new ResponseDto("The log You are looking for is :",
                "200",addressBookModel),
                HttpStatus.CREATED);


    }
    @GetMapping("/getallusersdto")
    public ResponseEntity<List<AddressBookDTO>> findAllUsersInDto(){
      return ResponseEntity.status(HttpStatus.OK).body(addressBookService.findAllUsersDto());
    }

    @GetMapping("/getallusersmodel")
    public ResponseEntity<List<AddressBookModel>> findAllUsersInModel(){
        return ResponseEntity.status(HttpStatus.OK).body(addressBookService.findAllUsersModel());
    }


    @DeleteMapping("/deleteDto/{addressId}")
    public ResponseEntity<ResponseDto> deleteUserByIdInDto(@PathVariable("addressId") UUID addressId){
        AddressBookDTO addressBookDTO = addressBookService.deleteUserByIdInDto(addressId);

        return new ResponseEntity<ResponseDto>(new ResponseDto("the Log you want is deleted successfully :",
                                                               "200", addressBookDTO),
                                                                HttpStatus.CREATED);

    }

    @DeleteMapping("/deleteModel/{addressId}")
    public ResponseEntity<ResponseDto> deleteUserByIdInModel(@PathVariable("addressId") UUID addressId){
        AddressBookModel addressBookModel= addressBookService.deleteUserByIdInModel(addressId);

        return new ResponseEntity<ResponseDto>(new ResponseDto("the Log you want is deleted successfully :",
                                                               "200", addressBookModel),
                                                                HttpStatus.CREATED);


    }

    @PutMapping("/updateinDto")
    public ResponseEntity<ResponseDto> changeLogInDto(@RequestBody @Valid EditDto log,
                                                      BindingResult bindingResult){


        if (bindingResult.hasErrors()){
            return new ResponseEntity<ResponseDto>(new ResponseDto(bindingResult.getAllErrors().
                    get(0).getDefaultMessage(),"101",null),
                    HttpStatus.BAD_REQUEST);

        }

        AddressBookDTO addressBookDTO = addressBookService.updateInDto(log);
        return new ResponseEntity<ResponseDto>(new ResponseDto("the log you want to update is : ",
                                                               "200",addressBookDTO),

                                                                HttpStatus.CREATED);
    }

    @PutMapping("/updateinmodel")
    public ResponseEntity<ResponseDto> changeLogInModel(@RequestBody @Valid EditDto log,
                                                      BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ResponseEntity<ResponseDto>(new ResponseDto(bindingResult.getAllErrors().
                    get(0).getDefaultMessage(),"101",null),
                    HttpStatus.BAD_REQUEST);

        }

        AddressBookModel addressBookModel = addressBookService.updateInModel(log);
        return new ResponseEntity<ResponseDto>(new ResponseDto("the log you want to update is : ",
                                                               "200",addressBookModel),
                                                                HttpStatus.CREATED);
    }









}

package com.example.address_book.repository;

import com.example.address_book.model.AddressBookModel;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookModel, UUID> {
  Optional<AddressBookModel> findByPhoneNumber(String phoneNumber);
}

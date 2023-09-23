package com.digitalwallet.customerservice.domain;

import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findByDocumentNumberOrPhoneNumber(String documentNumber, String phoneNumber);
}

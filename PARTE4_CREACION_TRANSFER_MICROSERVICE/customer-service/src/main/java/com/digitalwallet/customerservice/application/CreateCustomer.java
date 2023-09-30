package com.digitalwallet.customerservice.application;

import com.digitalwallet.customerservice.domain.Customer;
import com.digitalwallet.customerservice.domain.CustomerCreation;
import com.digitalwallet.customerservice.domain.CustomerRepository;
import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCustomer {
    private final CustomerRepository customerRepository;

    @Transactional(rollbackFor = Exception.class)
    public void save(CustomerCreation customerCreation) {
        if (customerRepository.findByDocumentNumberOrPhoneNumber(customerCreation.getDocumentNumber()
                , customerCreation.getPhoneNumber()).isPresent())
            throw new DigitalWalletGenericClientException("Customer already exists", HttpStatus.CONFLICT);
        customerRepository.save(Customer
                .builder()
                .surnames(customerCreation.getSurnames())
                .email(customerCreation.getEmail())
                .givenNames(customerCreation.getGivenNames())
                .documentType(customerCreation.getDocumentType())
                .phoneNumber(customerCreation.getPhoneNumber())
                .documentNumber(customerCreation.getDocumentNumber())
                .build());
    }
}

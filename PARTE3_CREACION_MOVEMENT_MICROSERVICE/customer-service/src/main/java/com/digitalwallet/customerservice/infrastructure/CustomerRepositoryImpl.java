package com.digitalwallet.customerservice.infrastructure;

import com.digitalwallet.customerservice.domain.Customer;
import com.digitalwallet.customerservice.domain.CustomerRepository;
import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletError;
import com.digitalwallet.customerservice.domain.exceptions.DigitalWalletGenericClientException;
import com.digitalwallet.customerservice.infrastructure.external.WalletAPIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Function;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
    private final CustomerMongoRepository customerMongoRepository;
    private final WalletAPIRepository walletAPIRepository;
    @Override
    public Customer save(Customer customer) {
        CustomerDocument customerDocument = customerMongoRepository
                .save(CustomerDocument
                        .builder()
                        .customerId(customer.getCustomerId())
                        .documentNumber(customer.getDocumentNumber())
                        .email(customer.getEmail())
                        .documentType(customer.getDocumentType())
                        .givenNames(customer.getGivenNames())
                        .surnames(customer.getSurnames())
                        .phoneNumber(customer.getPhoneNumber())
                        .build());
        ResponseEntity response = walletAPIRepository.createWallet(customer);
        this.ensureIsResponseEntityValidSucessful(response);
        return Customer
                .builder()
                .customerId(customerDocument.getCustomerId())
                .documentNumber(customerDocument.getDocumentNumber())
                .email(customerDocument.getEmail())
                .documentType(customerDocument.getDocumentType())
                .givenNames(customerDocument.getGivenNames())
                .surnames(customerDocument.getSurnames())
                .phoneNumber(customerDocument.getPhoneNumber())
                .build();
    }
    private void ensureIsResponseEntityValidSucessful(ResponseEntity response){
        if (!response.getStatusCode().is2xxSuccessful()){
            DigitalWalletError error = (DigitalWalletError) response.getBody();
            throw new DigitalWalletGenericClientException(error.getMessage(), error.getStatus());
        }
    }
    @Override
    public Optional<Customer> findByDocumentNumberOrPhoneNumber(String documentNumber, String phoneNumber) {
        Function<CustomerDocument, Customer> customerDocumentToCustomer = customerDocument -> Customer.builder()
                .customerId(customerDocument.getCustomerId())
                .documentNumber(customerDocument.getDocumentNumber())
                .email(customerDocument.getEmail())
                .documentType(customerDocument.getDocumentType())
                .givenNames(customerDocument.getGivenNames())
                .surnames(customerDocument.getSurnames())
                .phoneNumber(customerDocument.getPhoneNumber())
                .build();
        Optional<CustomerDocument> customerDocumentFoundOptional = customerMongoRepository
                .findByDocumentNumberOrPhoneNumber(documentNumber, phoneNumber);
        Optional<Customer> customerOptional = customerDocumentFoundOptional
                .map(customerDocumentToCustomer);
        return customerOptional;
    }
}

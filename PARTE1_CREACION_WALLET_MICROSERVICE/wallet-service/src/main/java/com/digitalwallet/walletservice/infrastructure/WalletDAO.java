package com.digitalwallet.walletservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WalletDAO extends MongoRepository<WalletDocument, String> {
    Boolean existsByCustomerDocumentNumberAndCustomerPhoneNumber(String documentNumber
            , String phoneNumber);
    Optional<WalletDocument> findByCustomerPhoneNumber(String phoneNumber);
}

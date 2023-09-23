package com.digitalwallet.movementsservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovementMongoRepository extends MongoRepository<MovementDocument, String> {
    List<MovementDocument> findByWalletIdOrderByRegistrationDateDesc(String walletId);
    Boolean existsByOperationNumber(String operationNumber);
}

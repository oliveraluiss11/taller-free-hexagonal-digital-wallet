package com.digitalwallet.transferservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransferMongoRepository extends MongoRepository<TransferDocument, String> {
}

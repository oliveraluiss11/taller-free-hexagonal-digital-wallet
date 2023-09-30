package com.digitalwallet.transferservice.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransferMongoDocument extends MongoRepository<TransferDocument, String> {
}

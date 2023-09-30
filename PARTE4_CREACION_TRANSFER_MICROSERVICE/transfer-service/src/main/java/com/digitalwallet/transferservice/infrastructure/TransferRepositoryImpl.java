package com.digitalwallet.transferservice.infrastructure;

import com.digitalwallet.transferservice.domain.Transfer;
import com.digitalwallet.transferservice.domain.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TransferRepositoryImpl implements TransferRepository {
    private final TransferMongoRepository repository;
    private final TransferMapper mapper;
    @Override
    public Transfer save(Transfer transfer) {
        TransferDocument documentCreated = repository.save(mapper.toDocument(transfer));
        return mapper.toDomain(documentCreated);
    }
}

package com.digitalwallet.movementsservice.infrastructure;

import com.digitalwallet.movementsservice.domain.Movement;
import com.digitalwallet.movementsservice.domain.MovementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MovementRepositoryImpl implements MovementRepository {
    private final MovementMongoRepository repository;
    private final MovementMapper movementMapper;

    @Override
    public Movement save(Movement request) {
        MovementDocument documentCreated = repository
                .save(movementMapper.toDocument(request));
        log.info("The movement was successfully recorded.", documentCreated);
        return movementMapper.toDomain(documentCreated);
    }

    @Override
    public List<Movement> findMovementsByWalletId(String walletId) {
        return repository.findByWalletIdOrderByRegistrationDateDesc(walletId)
                .stream()
                .map(movementDocument -> movementMapper
                        .toDomain(movementDocument)).collect(Collectors.toList());
    }

    @Override
    public Boolean existsMovementByOperationNumber(String operationNumber) {
        return repository.existsByOperationNumber(operationNumber);
    }
}

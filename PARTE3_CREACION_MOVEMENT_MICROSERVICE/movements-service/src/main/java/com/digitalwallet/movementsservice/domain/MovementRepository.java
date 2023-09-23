package com.digitalwallet.movementsservice.domain;

import java.util.List;

public interface MovementRepository {
    Movement save(Movement request);

    List<Movement> findMovementsByWalletId(String walletId);
    Boolean existsMovementByOperationNumber(String operationNumber);
}

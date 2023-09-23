package com.digitalwallet.movementsservice.infrastructure;

import com.digitalwallet.movementsservice.domain.Movement;
import org.springframework.stereotype.Component;

@Component
public class MovementMapper {
    public MovementDocument toDocument(Movement movement){
        return MovementDocument
                .builder()
                .movementId(movement.getMovementId())
                .registrationDate(movement.getRegistrationDate())
                .transferId(movement.getTransferId())
                .walletId(movement.getWalletId())
                .operationNumber(movement.getOperationNumber())
                .typeTransaction(movement.getTypeTransaction())
                .currency(movement.getCurrency())
                .amount(movement.getAmount())
                .build();
    }
    public Movement toDomain(MovementDocument document){
        return Movement
                .builder()
                .movementId(document.getMovementId())
                .walletId(document.getWalletId())
                .amount(document.getAmount())
                .currency(document.getCurrency())
                .operationNumber(document.getOperationNumber())
                .transferId(document.getTransferId())
                .registrationDate(document.getRegistrationDate())
                .typeTransaction(document.getTypeTransaction())
                .build();
    }
}

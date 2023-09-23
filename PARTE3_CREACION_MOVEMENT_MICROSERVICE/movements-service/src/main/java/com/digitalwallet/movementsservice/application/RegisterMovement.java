package com.digitalwallet.movementsservice.application;

import com.digitalwallet.movementsservice.domain.Movement;
import com.digitalwallet.movementsservice.domain.MovementCreation;
import com.digitalwallet.movementsservice.domain.MovementRepository;
import com.digitalwallet.movementsservice.domain.exceptions.DigitalWalletGenericClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegisterMovement {
    private final MovementRepository movementRepository;

    public void register(MovementCreation creation) {
        if (movementRepository.existsMovementByOperationNumber(creation.getOperationNumber()))
            throw new DigitalWalletGenericClientException("Movement has been registered", HttpStatus.CONFLICT);
        movementRepository.save(Movement
                .builder()
                        .typeTransaction(creation.getTypeTransaction())
                        .registrationDate(LocalDateTime.now())
                        .transferId(creation.getTransferId())
                        .operationNumber(creation.getOperationNumber())
                        .amount(creation.getAmount())
                        .currency(creation.getCurrency())
                        .walletId(creation.getWalletId())
                .build());
    }
}

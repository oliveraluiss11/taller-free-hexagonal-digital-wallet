package com.digitalwallet.movementsservice.application;

import com.digitalwallet.movementsservice.domain.Movement;
import com.digitalwallet.movementsservice.domain.MovementRepository;
import com.digitalwallet.movementsservice.domain.exceptions.DigitalWalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindMovementsByWalletId {
    private final MovementRepository movementRepository;

    public List<Movement> findByWalletId(String walletId) {
        List<Movement> movementList = movementRepository.findMovementsByWalletId(walletId);
        if (movementList.isEmpty())
            throw new DigitalWalletGenericClientException("List is empty", HttpStatus.NO_CONTENT);
        return movementList;
    }
}

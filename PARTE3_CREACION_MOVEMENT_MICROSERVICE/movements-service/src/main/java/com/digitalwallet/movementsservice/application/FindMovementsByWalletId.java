package com.digitalwallet.movementsservice.application;

import com.digitalwallet.movementsservice.domain.Movement;
import com.digitalwallet.movementsservice.domain.MovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FindMovementsByWalletId {
    private final MovementRepository movementRepository;
    public List<Movement> findByWalletId(String walletId){
        return movementRepository.findMovementsByWalletId(walletId);
    }
}

package com.digitalwallet.transferservice.infrastructure;

import com.digitalwallet.transferservice.domain.UpdateBalanceRequest;
import com.digitalwallet.transferservice.domain.Wallet;
import com.digitalwallet.transferservice.domain.WalletRepository;
import com.digitalwallet.transferservice.domain.exceptions.DigitalWalletGenericServerException;
import com.digitalwallet.transferservice.infrastructure.external.WalletAPIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WalletRepositoryImpl implements WalletRepository {
    private final WalletAPIRepository repository;
    public void updateBalance(String walletId, UpdateBalanceRequest request){
        repository.updateBalance(walletId, request);
    }

    @Override
    public Wallet findByPhoneNumber(String phoneNumber) {
        ResponseEntity<Wallet> response = repository.findByPhoneNumber(phoneNumber);
        if (!response.getStatusCode().is2xxSuccessful()){
            throw new DigitalWalletGenericServerException("Error al buscar wallet por numero de telefono");
        }
        return response.getBody();
    }
}

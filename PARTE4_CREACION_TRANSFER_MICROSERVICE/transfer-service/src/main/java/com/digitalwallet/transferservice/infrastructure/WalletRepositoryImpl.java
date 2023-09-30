package com.digitalwallet.transferservice.infrastructure;

import com.digitalwallet.transferservice.domain.UpdateBalanceRequest;
import com.digitalwallet.transferservice.domain.WalletRepository;
import com.digitalwallet.transferservice.infrastructure.external.WalletAPIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WalletRepositoryImpl implements WalletRepository {
    private final WalletAPIRepository repository;
    public void updateBalance(String walletId, UpdateBalanceRequest request){
        repository.updateBalance(walletId, request);
    }
}

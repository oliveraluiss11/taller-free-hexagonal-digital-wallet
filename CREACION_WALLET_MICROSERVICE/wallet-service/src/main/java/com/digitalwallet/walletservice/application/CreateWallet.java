package com.digitalwallet.walletservice.application;

import com.digitalwallet.walletservice.domain.Wallet;
import com.digitalwallet.walletservice.domain.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CreateWallet {
    private final WalletRepository walletRepository;
    public void create(Wallet wallet){
        walletRepository.saveOnlyOne(Wallet
                .builder()
                        .balance(BigDecimal.ZERO)
                        .currency("PEN")
                        .customer(wallet.getCustomer())
                .build());
    }
}

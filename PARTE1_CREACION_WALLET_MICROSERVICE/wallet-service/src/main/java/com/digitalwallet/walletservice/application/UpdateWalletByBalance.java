package com.digitalwallet.walletservice.application;

import com.digitalwallet.walletservice.domain.Wallet;
import com.digitalwallet.walletservice.domain.WalletRepository;
import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UpdateWalletByBalance {
    private final WalletRepository walletRepository;

    public void updateBalance(String walletId, BigDecimal balance){
        if (balance.compareTo(BigDecimal.ZERO)<0)
            throw new WalletGenericClientException("El valor del atributo 'balance' no puede ser menor que 0."
                    , HttpStatus.UNPROCESSABLE_ENTITY);

        Wallet walletFoundById = walletRepository.findById(walletId);

        walletRepository.save(Wallet
                .builder()
                        .walletId(walletFoundById.getWalletId())
                        .customer(walletFoundById.getCustomer())
                        .currency(walletFoundById.getCurrency())
                        .balance(balance)
                .build());
    }
}

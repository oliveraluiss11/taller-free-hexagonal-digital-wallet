package com.digitalwallet.walletservice.application;

import com.digitalwallet.walletservice.domain.Wallet;
import com.digitalwallet.walletservice.domain.WalletRepository;
import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindWallet {
    private final WalletRepository walletRepository;

    public Wallet findByPhoneNumber(String phoneNumber){
        if (!phoneNumber.matches("9[0-9]{8}")){
            throw new WalletGenericClientException("El número de teléfono es inválido", HttpStatus.BAD_REQUEST);
        }
        return walletRepository.findByPhoneNumber(phoneNumber);
    }

}

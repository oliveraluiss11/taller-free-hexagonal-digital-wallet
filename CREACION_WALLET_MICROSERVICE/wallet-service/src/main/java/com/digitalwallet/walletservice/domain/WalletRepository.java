package com.digitalwallet.walletservice.domain;

public interface WalletRepository {
    void save(Wallet wallet);
    Wallet findByPhoneNumber(String phoneNumber);
}

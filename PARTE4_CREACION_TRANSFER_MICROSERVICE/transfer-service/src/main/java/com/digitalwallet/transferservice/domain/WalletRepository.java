package com.digitalwallet.transferservice.domain;

public interface WalletRepository {
    void updateBalance(String walletId, UpdateBalanceRequest request);
    Wallet findByPhoneNumber(String phoneNumber);
}

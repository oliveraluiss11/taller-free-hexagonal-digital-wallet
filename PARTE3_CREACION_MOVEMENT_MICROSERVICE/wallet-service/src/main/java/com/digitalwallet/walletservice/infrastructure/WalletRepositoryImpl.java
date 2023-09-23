package com.digitalwallet.walletservice.infrastructure;

import com.digitalwallet.walletservice.domain.Wallet;
import com.digitalwallet.walletservice.domain.WalletRepository;
import com.digitalwallet.walletservice.domain.exceptions.WalletGenericClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WalletRepositoryImpl implements WalletRepository {
    private final WalletDAO walletDAO;
    @Override
    public void saveOnlyOne(Wallet wallet) {
        String documentNumber = wallet.getCustomer().getDocumentNumber();
        String phoneNumber = wallet.getCustomer().getPhoneNumber();
        this.insuranceExistWalletByDocumentNumberAndPhoneNumber(documentNumber
                , phoneNumber);
        WalletDocument walletDocument = WalletDocument
                .builder()
                .customer(wallet.getCustomer())
                .balance(wallet.getBalance())
                .currency(wallet.getCurrency())
                .build();
        walletDAO.save(walletDocument);
    }
    @Override
    public void save(Wallet wallet){
        WalletDocument walletDocument = WalletDocument
                .builder()
                .walletId(wallet.getWalletId())
                .customer(wallet.getCustomer())
                .balance(wallet.getBalance())
                .currency(wallet.getCurrency())
                .build();
        walletDAO.save(walletDocument);
    }
    @Override
    public Wallet findByPhoneNumber(String phoneNumber) {
        WalletDocument walletDocument = walletDAO.findByCustomerPhoneNumber(phoneNumber)
                .orElseThrow(()-> new WalletGenericClientException("Wallet not found", HttpStatus.NOT_FOUND));
        return  Wallet
                .builder()
                .walletId(walletDocument.getWalletId())
                .customer(walletDocument.getCustomer())
                .currency(walletDocument.getCurrency())
                .balance(walletDocument.getBalance())
                .build();
    }

    @Override
    public Wallet findById(String walletId) {
        WalletDocument walletDocumentFound = walletDAO.findById(walletId)
                .orElseThrow(()-> new WalletGenericClientException("Wallet not found", HttpStatus.NOT_FOUND));
        return Wallet
                .builder()
                .balance(walletDocumentFound.getBalance())
                .walletId(walletDocumentFound.getWalletId())
                .currency(walletDocumentFound.getCurrency())
                .customer(walletDocumentFound.getCustomer())
                .build();
    }

    private void insuranceExistWalletByDocumentNumberAndPhoneNumber(String documentNumber,
                                                                    String phoneNumber) {
        if (walletDAO.existsByCustomerDocumentNumberAndCustomerPhoneNumber(documentNumber, phoneNumber))
            throw new WalletGenericClientException("Wallet already exists in database", HttpStatus.CONFLICT);
    }
}

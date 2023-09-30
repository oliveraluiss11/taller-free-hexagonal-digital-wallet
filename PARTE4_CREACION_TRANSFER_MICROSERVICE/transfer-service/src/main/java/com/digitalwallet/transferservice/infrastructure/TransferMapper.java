package com.digitalwallet.transferservice.infrastructure;

import com.digitalwallet.transferservice.domain.Transfer;
import org.springframework.stereotype.Component;

@Component
public class TransferMapper {
    public Transfer toDomain(TransferDocument document){
        return Transfer
                .builder()
                .transferId(document.getTransferId())
                .registrationDate(document.getRegistrationDate())
                .description(document.getDescription())
                .destinationWalletId(document.getDestinationWalletId())
                .originWalletId(document.getOriginWalletId())
                .amount(document.getAmount())
                .currency(document.getCurrency())
                .build();
    }
    public TransferDocument toDocument(Transfer domain){
        return TransferDocument
                .builder()
                .transferId(domain.getTransferId())
                .registrationDate(domain.getRegistrationDate())
                .description(domain.getDescription())
                .destinationWalletId(domain.getDestinationWalletId())
                .originWalletId(domain.getOriginWalletId())
                .amount(domain.getAmount())
                .currency(domain.getCurrency())
                .build();
    }

}

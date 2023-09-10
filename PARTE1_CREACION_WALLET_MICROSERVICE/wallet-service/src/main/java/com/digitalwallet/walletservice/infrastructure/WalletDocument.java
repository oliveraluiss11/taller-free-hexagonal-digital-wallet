package com.digitalwallet.walletservice.infrastructure;

import com.digitalwallet.walletservice.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "wallet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class WalletDocument {
    @Id
    private String walletId;
    private BigDecimal balance;
    private String currency;
    private Customer customer;
}

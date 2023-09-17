package com.digitalwallet.walletservice.presentation;

import com.digitalwallet.walletservice.application.CreateWallet;
import com.digitalwallet.walletservice.application.FindWallet;
import com.digitalwallet.walletservice.application.UpdateWalletByBalance;
import com.digitalwallet.walletservice.domain.Customer;
import com.digitalwallet.walletservice.domain.UpdateBalance;
import com.digitalwallet.walletservice.domain.Wallet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final CreateWallet createWallet;
    private final FindWallet findWallet;
    private final UpdateWalletByBalance updateWalletByBalance;

    @PostMapping
    private ResponseEntity create(@Valid @RequestBody WalletRequest request) {
        createWallet.create(Wallet
                .builder()
                .customer(
                        Customer
                                .builder()
                                .documentNumber(request.getDocumentNumber())
                                .phoneNumber(request.getPhoneNumber())
                                .givenNames(request.getGivenNames())
                                .surnames(request.getSurnames())
                                .email(request.getEmail())
                                .documentType(request.getDocumentType())
                                .build()
                )
                .build());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity findByPhoneNumber(@RequestParam String phoneNumber) {
        return ResponseEntity.ok(findWallet.findByPhoneNumber(phoneNumber));
    }

    @PatchMapping("/{walletId}/balance")
    private ResponseEntity updateBalance(@PathVariable String walletId
            , @RequestBody UpdateBalance balance) {
        updateWalletByBalance.updateBalance(walletId, balance.getBalance());
        return ResponseEntity.accepted().build();
    }

}

package com.digitalwallet.transferservice.infrastructure.external;

import com.digitalwallet.transferservice.domain.UpdateBalanceRequest;
import com.digitalwallet.transferservice.domain.Wallet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "http://localhost:9001", name = "wallet-service")
public interface WalletAPIRepository {
    @GetMapping
    ResponseEntity<Wallet> findByPhoneNumber(@RequestParam String phoneNumber);

    @PatchMapping("/{walletId}/balance")
    ResponseEntity<Void> updateBalance(@PathVariable String walletId
            , @RequestBody UpdateBalanceRequest updateBalance);
}

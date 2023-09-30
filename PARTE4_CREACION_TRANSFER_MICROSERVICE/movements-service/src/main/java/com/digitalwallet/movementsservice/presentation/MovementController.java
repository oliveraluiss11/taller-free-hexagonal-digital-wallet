package com.digitalwallet.movementsservice.presentation;

import com.digitalwallet.movementsservice.application.FindMovementsByWalletId;
import com.digitalwallet.movementsservice.application.RegisterMovement;
import com.digitalwallet.movementsservice.domain.Movement;
import com.digitalwallet.movementsservice.domain.MovementCreation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movements")
@RequiredArgsConstructor
public class MovementController {
    private final RegisterMovement registerMovement;
    private final FindMovementsByWalletId findMovementsByWalletId;
    @PostMapping
    public ResponseEntity<Void> createMovement(@Valid @RequestBody MovementCreation movementCreation) {
        registerMovement.register(movementCreation);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<Movement>> getMovementsByWalletId(@RequestParam(name = "walletId") String walletId) {
        return ResponseEntity.status(HttpStatus.OK).body(findMovementsByWalletId.findByWalletId(walletId));
    }
}

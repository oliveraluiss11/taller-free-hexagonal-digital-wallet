package com.digitalwallet.movementsservice.presentation;

import com.digitalwallet.movementsservice.domain.MovementCreation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movements")
public class MovementController {
    @PostMapping
    public ResponseEntity<Void> createMovement(@Valid @RequestBody MovementCreation movementCreation) {
        // Aquí puedes procesar y almacenar el objeto 'movementCreation' en tu lógica de negocio
        // ...

        // En caso de éxito, devolvemos una respuesta con estado HTTP 201 (Created) y sin contenido
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

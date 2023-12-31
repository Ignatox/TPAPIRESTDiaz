package com.utn.TPAPIRESTDiaz.controllers;

import com.utn.TPAPIRESTDiaz.entities.Persona;
import com.utn.TPAPIRESTDiaz.services.PersonaService;
import com.utn.TPAPIRESTDiaz.services.PersonaServiceImpl;
import org.apache.coyote.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/BD1/personas")
public class PersonaController extends BaseControllerImpl <Persona, PersonaServiceImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));

        }

    }
    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));

        }

    }
}
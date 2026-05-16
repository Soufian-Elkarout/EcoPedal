package com.ecoPedal.backend.controller;

import com.ecoPedal.backend.entity.Administrateur;
import com.ecoPedal.backend.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/administrateurs")
@CrossOrigin(origins = "*")
public class AdministrateurController {

    @Autowired
    private AdministrateurService administrateurService;

    @PostMapping
    public ResponseEntity<Administrateur> creerAdministrateur(@RequestBody Administrateur administrateur) {
        return ResponseEntity.ok(administrateurService.creerAdministrateur(administrateur));
    }

    @GetMapping
    public ResponseEntity<List<Administrateur>> getTousAdministrateurs() {
        return ResponseEntity.ok(administrateurService.getTousAdministrateurs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrateur> getAdministrateurById(@PathVariable Long id) {
        return administrateurService.getAdministrateurById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrateur> modifierAdministrateur(
            @PathVariable Long id,
            @RequestBody Administrateur administrateur) {
        return ResponseEntity.ok(administrateurService.modifierAdministrateur(id, administrateur));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAdministrateur(@PathVariable Long id) {
        administrateurService.supprimerAdministrateur(id);
        return ResponseEntity.noContent().build();
    }
}
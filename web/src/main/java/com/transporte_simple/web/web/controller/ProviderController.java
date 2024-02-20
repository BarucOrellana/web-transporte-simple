package com.transporte_simple.web.web.controller;

import com.transporte_simple.web.domain.service.ProviderService;
import com.transporte_simple.web.persistence.entities.ProviderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider")
public class ProviderController {
    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }


   @PostMapping("/new-provider")
    public ResponseEntity<ProviderEntity> save(@RequestBody ProviderEntity provider) {
        if (!this.providerService.exists(provider.getIdProvider())) {
            return ResponseEntity.ok(this.providerService.save(provider));
        }

        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/new-provider")
    public ResponseEntity<ProviderEntity> update(@RequestBody ProviderEntity provider) {
        if (provider.getIdProvider() != null && this.providerService.exists(provider.getIdProvider())) {
            return ResponseEntity.ok(this.providerService.save(provider));
        }

        return ResponseEntity.badRequest().build();
    }

}

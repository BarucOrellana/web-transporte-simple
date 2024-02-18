package com.transporte_simple.web.web.controller;

import com.transporte_simple.web.domain.service.SellerService;
import com.transporte_simple.web.persistence.entities.ProviderEntity;
import com.transporte_simple.web.persistence.entities.SellerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seller")
public class SellerController {
    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/new-seller")
    public ResponseEntity<SellerEntity> save(@RequestBody SellerEntity seller) {
        if (!this.sellerService.exists(seller.getIdSeller())) {
            return ResponseEntity.ok(this.sellerService.save(seller));
        }

        return ResponseEntity.badRequest().build();
    }
}

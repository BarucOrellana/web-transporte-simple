package com.transporte_simple.web.web.controller;

import com.transporte_simple.web.domain.service.SellerService;
import com.transporte_simple.web.persistence.entities.ProviderEntity;
import com.transporte_simple.web.persistence.entities.SellerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (seller.getIdSeller() == null || !this.sellerService.exists(seller.getIdSeller())) {
            return ResponseEntity.ok(this.sellerService.save(seller));
        }

        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/update-seller")
    public ResponseEntity<SellerEntity> update(@RequestBody SellerEntity seller) {
        if (seller.getIdSeller() != null && this.sellerService.exists(seller.getIdSeller())) {
            return ResponseEntity.ok(this.sellerService.save(seller));
        }
        return ResponseEntity.badRequest().build();
    }
}

package com.transporte_simple.web.web.controller;

import com.transporte_simple.web.domain.service.SellerService;
import com.transporte_simple.web.persistence.entities.SellerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

    @GetMapping("/my-account/{id_seller}")
    public ResponseEntity<SellerEntity> getSeller(@PathVariable("id_seller") int idSeller){
        return ResponseEntity.ok(this.sellerService.getSeller(idSeller));
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

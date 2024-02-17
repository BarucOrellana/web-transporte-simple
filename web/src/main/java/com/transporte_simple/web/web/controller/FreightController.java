package com.transporte_simple.web.web.controller;

import com.transporte_simple.web.domain.service.FreightService;
import com.transporte_simple.web.persistence.entities.FreightEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Freights")
public class FreightController {
    private final FreightService freightService;

    public FreightController(FreightService freightService) {
        this.freightService = freightService;
    }

    @GetMapping
    public ResponseEntity<List<FreightEntity>> getAll(){
        return ResponseEntity.ok(this.freightService.getAll());
    }

    @GetMapping("/{id_seller}")
    public ResponseEntity<List<FreightEntity>> findBySeller(@PathVariable("id_seller") Integer idSeller){
        return ResponseEntity.ok(this.freightService.findBySeller(idSeller));
    }


}

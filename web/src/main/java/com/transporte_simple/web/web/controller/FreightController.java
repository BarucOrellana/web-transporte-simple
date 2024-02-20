package com.transporte_simple.web.web.controller;

import com.transporte_simple.web.domain.service.FreightService;
import com.transporte_simple.web.persistence.entities.FreightEntity;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/freights")
public class FreightController {
    private final FreightService freightService;

    @Autowired
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

    @PostMapping("/new-freight")
    public ResponseEntity<FreightEntity> save(@RequestParam FreightEntity freight) {
        if (!this.freightService.exists(freight.getIdFreight())) {
            return ResponseEntity.ok(this.freightService.save(freight));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/update-freight")
    public ResponseEntity<FreightEntity> update(@RequestParam FreightEntity freight) {
        if (freight.getFreights() != null && this.freightService.exists(freight.getIdFreight())) {
            return ResponseEntity.ok(this.freightService.save(freight));
        }
        return ResponseEntity.badRequest().build();
    }

}

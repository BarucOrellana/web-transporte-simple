package com.transporte_simple.web.web.controller;

import com.transporte_simple.web.domain.service.FreightService;
import com.transporte_simple.web.persistence.entities.FreightEntity;
import com.transporte_simple.web.persistence.projection.FreightSummary;
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

    @GetMapping("/all")
    public ResponseEntity<List<FreightSummary>> getAllFreightSummaries(){
        return ResponseEntity.ok(this.freightService.getAllFreightSummaries());
    }
    @GetMapping("/{id_seller}")
    public ResponseEntity<List<FreightSummary>> findBySeller(@PathVariable("id_seller") int idSeller){
        return ResponseEntity.ok(this.freightService.findBySeller(idSeller));
    }

    @PostMapping("/new-freight")
    public ResponseEntity<FreightEntity> save(@RequestBody FreightEntity freight) {
        if (freight.getIdFreight() == null || !this.freightService.exists(freight.getIdFreight())) {
            return ResponseEntity.ok(this.freightService.save(freight));
            }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/update-freight")
    public ResponseEntity<FreightEntity> update(@RequestBody FreightEntity freight) {
        if (freight.getIdFreight() != null && this.freightService.exists(freight.getIdFreight())) {
            return ResponseEntity.ok(this.freightService.save(freight));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id_freight}")
    public ResponseEntity<FreightEntity> deleteById(@PathVariable("id_freight") Integer idFreight){
     if (this.freightService.exists(idFreight)){
         this.freightService.delete(idFreight);
         return ResponseEntity.ok().build();
     }
     return ResponseEntity.badRequest().build();
    }
}

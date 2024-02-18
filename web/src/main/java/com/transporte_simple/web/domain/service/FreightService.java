package com.transporte_simple.web.domain.service;

import com.transporte_simple.web.persistence.entities.FreightEntity;
import com.transporte_simple.web.persistence.repositories.FreightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreightService {
    private final FreightRepository freightRepository;

    @Autowired
    public FreightService(FreightRepository freightRepository) {
        this.freightRepository = freightRepository;
    }

    public List<FreightEntity> getAll(){
        return  this.freightRepository.findAll();
    }

    public List<FreightEntity> findBySeller(int idSeller){
        return this.freightRepository.findBySeller(idSeller);
    }

    public FreightEntity save(FreightEntity freight){
        return this.freightRepository.save(freight);
    }
    public boolean exists(Integer id){
        return this.freightRepository.existsById(id);
    }

}

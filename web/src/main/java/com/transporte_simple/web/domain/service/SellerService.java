package com.transporte_simple.web.domain.service;

import com.transporte_simple.web.persistence.entities.SellerEntity;
import com.transporte_simple.web.persistence.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
    public Optional<SellerEntity> findSeller(int idSeller){return this.sellerRepository.findById(idSeller); }
    public SellerEntity save(SellerEntity seller){return this.sellerRepository.save(seller);
    }
    public boolean exists(Integer id){
        return this.sellerRepository.existsById(id);
    }
}

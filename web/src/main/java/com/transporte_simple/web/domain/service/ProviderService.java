package com.transporte_simple.web.domain.service;

import com.transporte_simple.web.persistence.entities.ProviderEntity;
import com.transporte_simple.web.persistence.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public ProviderEntity save(ProviderEntity provider){
        return this.providerRepository.save(provider);
    }
    public boolean exists(Integer id){
        return this.providerRepository.existsById(id);
    }
}

package com.example.firstapp0.Service;

import com.example.firstapp0.Entity.Provider;
import com.example.firstapp0.Repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Provider getProviderById(int id) {
        return providerRepository.findById(id).orElse(null);
    }

    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider updateProvider(int id, Provider provider) {
        provider.setId(id);
        return providerRepository.save(provider);
    }

    public void deleteProvider(int id) {
        providerRepository.deleteById(id);
    }
}

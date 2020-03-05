package com.example.demo.tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    public Tenant create(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    public List<Tenant> findAll() {
        return tenantRepository.findAll();
    }

    public Tenant updateById(int id, Tenant tenant) {
        tenantRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        tenant.setId(id);
        return tenantRepository.save(tenant);
    }

    @Transactional
    public void deleteById(int id) {
        tenantRepository.deleteById(id);
    }
}
package com.challenge.service.interfaces;

import com.challenge.entity.Company;
import com.challenge.repository.CompanyRepoisitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyServiceImpl implements CompanyServiceInterface {

    @Autowired
    private CompanyRepoisitory companyRepoisitory;

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepoisitory.findById(id);
    }

    @Override
    public List<Company> findByAccelerationId(Long accelerationId) {
        return companyRepoisitory.findbyAccelerationId(accelerationId);
    }

    @Override
    public List<Company> findByUserId(Long userId) {
        return companyRepoisitory.findByUserId(userId);
    }

    @Override
    public Company save(Company object) {
        return companyRepoisitory.save(object);
    }
}

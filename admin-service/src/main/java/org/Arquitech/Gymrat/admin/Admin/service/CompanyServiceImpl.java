package org.Arquitech.Gymrat.admin.Admin.service;

import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Company;
import org.Arquitech.Gymrat.admin.Admin.domain.persistence.CompanyRepository;
import org.Arquitech.Gymrat.admin.Admin.domain.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }

    @Override
    public List<Company> fetchAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> fetchById(Integer id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }
}

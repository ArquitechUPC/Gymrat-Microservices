package org.Arquitech.Gymrat.admin.Admin.domain.service;

import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> fetchAll();

    Optional<Company> fetchById(Integer id);

    Company save(Company company);
}

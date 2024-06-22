package org.Arquitech.Gymrat.admin.Admin.domain.persistence;

import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}

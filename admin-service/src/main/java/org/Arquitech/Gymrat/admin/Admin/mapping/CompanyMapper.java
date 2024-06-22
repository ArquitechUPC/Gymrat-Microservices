package org.Arquitech.Gymrat.admin.Admin.mapping;

import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Company;
import org.Arquitech.Gymrat.admin.Admin.resource.CompanyResource;
import org.Arquitech.Gymrat.admin.Admin.resource.CreateCompanyResource;
import org.Arquitech.Gymrat.admin.Shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class CompanyMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Company toModel(CreateCompanyResource resource){return this.mapper.map(resource, Company.class);}

    public CompanyResource toResource(Company company){return this.mapper.map(company, CompanyResource.class);}
}

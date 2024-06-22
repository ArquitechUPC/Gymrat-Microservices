package org.Arquitech.Gymrat.admin.Admin.mapping;

import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Admin;
import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Company;
import org.Arquitech.Gymrat.admin.Admin.resource.AdminResource;
import org.Arquitech.Gymrat.admin.Admin.resource.CompanyResource;
import org.Arquitech.Gymrat.admin.Admin.resource.CreateAdminResource;
import org.Arquitech.Gymrat.admin.Admin.resource.CreateCompanyResource;
import org.Arquitech.Gymrat.admin.Shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class AdminMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Admin toModel(CreateAdminResource resource){return this.mapper.map(resource, Admin.class);}

    public AdminResource toResource(Admin admin){return this.mapper.map(admin, AdminResource.class);}
}

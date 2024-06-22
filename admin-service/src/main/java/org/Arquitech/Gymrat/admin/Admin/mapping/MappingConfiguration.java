package org.Arquitech.Gymrat.admin.Admin.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("adminMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public AdminMapper adminMapper(){return new AdminMapper();}

    @Bean
    public CompanyMapper companyMapper(){return new CompanyMapper();}

}

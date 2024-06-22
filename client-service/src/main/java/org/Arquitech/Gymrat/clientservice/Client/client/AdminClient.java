package org.Arquitech.Gymrat.clientservice.Client.client;

import org.Arquitech.Gymrat.clientservice.Client.resource.client.CompanyResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "admin-service", url = "http://localhost:8080",path = "/api/v1/admins")
public interface AdminClient {

    @GetMapping("{companyId}")
    Optional<CompanyResource> existCompany(@PathVariable Integer companyId);

}

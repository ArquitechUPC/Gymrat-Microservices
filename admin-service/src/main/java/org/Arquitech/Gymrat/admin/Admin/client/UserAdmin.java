package org.Arquitech.Gymrat.admin.Admin.client;

import org.Arquitech.Gymrat.admin.Admin.resource.RequestUserCompany;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service", url = "http://localhost:8080", path = "/api/v1/auth")
public interface UserAdmin {

    @PostMapping("/register-admin")
    Integer ObtainUserId(@RequestBody RequestUserCompany request);
}

package org.Arquitech.Gymrat.trainer_service.Trainer.client;

import org.Arquitech.Gymrat.trainer_service.Trainer.resource.trainer.RequestUserCompany;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service", url = "http://localhost:8080", path = "/api/v1/auth")
public interface UserTrainer {
    @PostMapping("/register-trainer")
    Integer ObtainUserId(@RequestBody RequestUserCompany request);
}

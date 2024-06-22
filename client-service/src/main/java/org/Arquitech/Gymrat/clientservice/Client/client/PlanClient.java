package org.Arquitech.Gymrat.clientservice.Client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.Optional;

@FeignClient(name = "plan-service", url = "http://localhost:8080", path = "/api/v1/plans")
public interface PlanClient {
    @GetMapping("/{planId}")
    Optional<?> existPlanById(@PathVariable Integer planId);
}

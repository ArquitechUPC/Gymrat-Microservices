package org.Arquitech.Gymrat.classservice.Class.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "trainer-service", url = "http://localhost:8080", path = "/api/v1/trainers")
public interface TrainerClass {
    @GetMapping("/availability-trainer/{trainerId}")
    boolean trainerAvailability(@PathVariable Integer trainerId);
}

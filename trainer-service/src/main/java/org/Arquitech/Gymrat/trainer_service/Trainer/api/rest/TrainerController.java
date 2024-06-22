package org.Arquitech.Gymrat.trainer_service.Trainer.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.Arquitech.Gymrat.trainer_service.Trainer.domain.model.entity.Trainer;
import org.Arquitech.Gymrat.trainer_service.Trainer.domain.service.TrainerService;
import org.Arquitech.Gymrat.trainer_service.Trainer.mapping.trainer.TrainerMapper;
import org.Arquitech.Gymrat.trainer_service.Trainer.resource.trainer.CreateTrainerUserResource;
import org.Arquitech.Gymrat.trainer_service.Trainer.resource.trainer.CreateTrainerResource;
import org.Arquitech.Gymrat.trainer_service.Trainer.resource.trainer.TrainerResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Trainers", description = "Create, Read, Update and delete trainers entities")
@RestController
@RequestMapping("/api/v1/trainers")
@AllArgsConstructor
public class TrainerController {
    private final TrainerService trainerService;
    private final TrainerMapper mapper;


    @Operation(summary = "Get all registered trainers", responses = {
            @ApiResponse(description = "Successfully fetched all trainers",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrainerResource.class)))
    })
    @GetMapping
    public List<Trainer> fetchAll() {
        return trainerService.fetchAll();
    }

    @Operation(summary = "Get a trainer by id", responses = {
            @ApiResponse(description = "Successfully fetched trainer by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrainerResource.class)))
    })
    @GetMapping("{id}")
    public TrainerResource fetchById(@PathVariable Integer id) {
        return this.mapper.toResource(trainerService.fetchById(id).get());
    }

    @Operation(summary = "Save a trainer", responses = {
            @ApiResponse(description = "Trainer successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrainerResource.class)))
    })
    @PostMapping("/company/{companyId}")
    public TrainerResource save(@RequestBody CreateTrainerUserResource resource, @PathVariable Integer companyId){

        CreateTrainerResource trainerResource = new CreateTrainerResource();
        trainerResource.setGivenUser(trainerService.obtainUserId(
                resource.getUsername(), resource.getEmail(), resource.getPassword(),
                resource.getPhoneNumber(), resource.getAddress(), resource.getCity(), companyId));

        trainerResource.setBio(resource.getBio());
        trainerResource.setSpeciality(resource.getSpeciality());


        return this.mapper.toResource(trainerService.save(this.mapper.toModel(trainerResource)));
    }

    @GetMapping("/availability-trainer/{id}")
    public ResponseEntity<?> availabilityTrainer(@PathVariable Integer id) {
        return ResponseEntity.ok(trainerService.availabilityTrainer(id));
    }
}

package org.Arquitech.Gymrat.trainer_service.Trainer.mapping.trainer;

import org.Arquitech.Gymrat.trainer_service.Shared.mapping.EnhancedModelMapper;
import org.Arquitech.Gymrat.trainer_service.Trainer.domain.model.entity.Trainer;
import org.Arquitech.Gymrat.trainer_service.Trainer.resource.trainer.CreateTrainerResource;
import org.Arquitech.Gymrat.trainer_service.Trainer.resource.trainer.TrainerResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class TrainerMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public Trainer toModel(CreateTrainerResource resource){ return this.mapper.map(resource, Trainer.class); }

    public TrainerResource toResource(Trainer trainer){ return this.mapper.map(trainer, TrainerResource.class); }
}

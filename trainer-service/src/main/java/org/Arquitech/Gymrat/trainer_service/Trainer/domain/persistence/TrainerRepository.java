package org.Arquitech.Gymrat.trainer_service.Trainer.domain.persistence;

import org.Arquitech.Gymrat.trainer_service.Trainer.domain.model.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
}

package org.Arquitech.Gymrat.trainer_service.Trainer.domain.service;

import org.Arquitech.Gymrat.trainer_service.Trainer.domain.model.entity.Trainer;

import java.util.List;
import java.util.Optional;

public interface TrainerService {
    List<Trainer> fetchAll();
    Optional<Trainer> fetchById(Integer id);
    Integer obtainUserId(String username, String email, String password, String phoneNumber, String address, String city, Integer companyId);
    Trainer save(Trainer trainer);
    boolean availabilityTrainer(Integer id);
    //añadir cambiar el inServices del trainer
    //void UpdateInService(Integer id);
}

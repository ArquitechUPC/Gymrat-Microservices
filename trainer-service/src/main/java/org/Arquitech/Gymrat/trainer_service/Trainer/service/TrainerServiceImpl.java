package org.Arquitech.Gymrat.trainer_service.Trainer.service;

import org.Arquitech.Gymrat.trainer_service.Shared.exception.CustomException;
import org.Arquitech.Gymrat.trainer_service.Trainer.client.UserTrainer;
import org.Arquitech.Gymrat.trainer_service.Trainer.domain.model.entity.Trainer;
import org.Arquitech.Gymrat.trainer_service.Trainer.domain.persistence.TrainerRepository;
import org.Arquitech.Gymrat.trainer_service.Trainer.domain.service.TrainerService;
import org.Arquitech.Gymrat.trainer_service.Trainer.resource.trainer.RequestUserCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private UserTrainer userTrainer;

    public TrainerServiceImpl(TrainerRepository trainerRepository, UserTrainer userTrainer) {
        this.trainerRepository = trainerRepository;
        this.userTrainer = userTrainer;
    }
    @Override
    public List<Trainer> fetchAll() {
        return trainerRepository.findAll();
    }

    @Override
    public Optional<Trainer> fetchById(Integer id) {
        return trainerRepository.findById(id);
    }

    @Override
    public Integer obtainUserId(String username, String email, String password, String phoneNumber, String address, String city, Integer companyId) {
        RequestUserCompany request = new RequestUserCompany();
        request.setUsername(username);
        request.setEmail(email);
        request.setPassword(password);
        request.setPhoneNumber(phoneNumber);
        request.setAddress(address);
        request.setCity(city);
        request.setCompanyId(companyId);


        return userTrainer.ObtainUserId(request);
    }

    @Override
    public Trainer save(Trainer trainer) {
        trainer.setOnService(true);
        return trainerRepository.save(trainer);
    }

    @Override
    public boolean availabilityTrainer(Integer id) {
        Trainer aux = trainerRepository.findById(id).orElseThrow( () -> new CustomException("Trainer not found", HttpStatus.NOT_FOUND));
        if(aux.getOnService()){
            return true;
        }
        return false;
    }
}

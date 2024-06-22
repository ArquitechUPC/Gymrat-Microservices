package org.Arquitech.Gymrat.classservice.Class.service;


import org.Arquitech.Gymrat.classservice.Class.client.TrainerClass;
import org.Arquitech.Gymrat.classservice.Class.domain.model.entity.Class;
import org.Arquitech.Gymrat.classservice.Class.domain.persistence.ClassRepository;
import org.Arquitech.Gymrat.classservice.Class.domain.service.ClassService;
import org.Arquitech.Gymrat.classservice.Shared.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private TrainerClass trainerClass;

    @Autowired
    private Validator validator;

    public ClassServiceImpl(ClassRepository classRepository, TrainerClass trainerClass, Validator validator) {
        this.classRepository = classRepository;
        this.trainerClass = trainerClass;
        this.validator = validator;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Class> fetchAll() {
        return classRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Class> fetchById(Integer Id) {
        if (classRepository.existsById(Id)) {
            return classRepository.findById(Id);
        } else {
            throw new CustomException("Class not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Class save(Class aClass) {
        aClass.setActualCapacity(aClass.getCapacity());
        Set<ConstraintViolation<Class>> violations = validator.validate(aClass);
        if (!violations.isEmpty()) {
            throw new CustomException("Error", HttpStatus.NOT_FOUND);
        }
        if(trainerClass.trainerAvailability(aClass.getCoachId())){
          return classRepository.save(aClass);
        }
        else{
          throw new CustomException("Trainer not found or out of service", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Class update(Class aClass) {
        Set<ConstraintViolation<Class>> violations = validator.validate(aClass);
        if (!violations.isEmpty()) {
            throw new CustomException("Error", HttpStatus.NOT_FOUND);
        }

        return classRepository.findById(aClass.getId()).map(aClassToUpdate -> {
            aClassToUpdate.setName(aClass.getName());
            aClassToUpdate.setDescription(aClass.getDescription());
            aClassToUpdate.setDuration(aClass.getDuration());
            aClassToUpdate.setCapacity(aClass.getCapacity());
            aClassToUpdate.setActualCapacity(aClass.getActualCapacity());
            aClassToUpdate.setInstructor(aClass.getInstructor());
            aClassToUpdate.setType(aClass.getType());
            aClassToUpdate.setLevel(aClass.getLevel());
            aClassToUpdate.setRoom(aClass.getRoom());
            aClassToUpdate.setCoachId(aClass.getCoachId());
            return classRepository.save(aClassToUpdate);
        }).orElseThrow(() -> new CustomException("Class not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public boolean deleteById(Integer id) {
        var classToDelete = classRepository.findById(id)
                .orElseThrow(() -> new CustomException("Class not found", HttpStatus.NOT_FOUND));

        classRepository.delete(classToDelete);
        return true;
    }

    @Override
    public List<Class> fetchByClient(Integer id) {

        return null;
    }

    @Override
    public Class updateVacancy(Integer id) {
        Class aux = classRepository.findById(id).get();
        aux.setActualCapacity((aux.getActualCapacity().intValue())-1);
        return classRepository.save(aux);
    }

    @Override
    public Class increasesVacancy(Integer id) {
        Class aux = classRepository.findById(id).get();
        aux.setActualCapacity((aux.getActualCapacity().intValue())+1);
        return classRepository.save(aux);
    }

}

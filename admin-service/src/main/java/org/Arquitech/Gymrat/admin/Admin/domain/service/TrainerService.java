package org.Arquitech.Gymrat.admin.Admin.domain.service;

import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Trainer;

import java.util.*;

public interface TrainerService {
    List<Trainer> fetchAll();
    Optional<Trainer> fetchById(Integer id);
    Trainer save(Trainer trainer);
    Trainer update(Trainer trainer);
    boolean deleteById(Integer id);
}

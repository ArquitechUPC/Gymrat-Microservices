package org.Arquitech.Gymrat.admin.Admin.domain.persistence;

import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

}

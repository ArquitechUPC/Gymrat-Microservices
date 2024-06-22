package org.Arquitech.Gymrat.trainer_service.Trainer.domain.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer givenUser;
    private String speciality;
    private Boolean onService;
    private String bio;
    private Double rating;

    @ElementCollection
    private List<Integer> givenClasses;
}

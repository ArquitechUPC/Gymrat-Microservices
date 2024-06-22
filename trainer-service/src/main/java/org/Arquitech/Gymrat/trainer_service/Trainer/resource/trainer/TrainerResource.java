package org.Arquitech.Gymrat.trainer_service.Trainer.resource.trainer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainerResource {
    private Integer id;
    private Integer givenUser;
    private String speciality;
    private Boolean onService;
    private String bio;
    private Double rating;
}

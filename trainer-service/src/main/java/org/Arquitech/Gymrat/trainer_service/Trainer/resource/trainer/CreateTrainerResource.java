package org.Arquitech.Gymrat.trainer_service.Trainer.resource.trainer;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTrainerResource {
    @NotNull
    private Integer givenUser;
    private String speciality;
    private String bio;
}

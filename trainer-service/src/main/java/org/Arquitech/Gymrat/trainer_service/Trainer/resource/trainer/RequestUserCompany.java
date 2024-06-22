package org.Arquitech.Gymrat.trainer_service.Trainer.resource.trainer;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserCompany {
    @NotNull
    String username;
    @NotNull
    String email;
    @NotNull
    String password;
    String phoneNumber;
    String address;
    String city;
    @NotNull
    Integer companyId;
}

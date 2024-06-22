package org.Arquitech.Gymrat.admin.Admin.resource;

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

package org.Arquitech.Gymrat.classservice.Class.resource.clas;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateClassResource {
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Integer duration;
    @NotNull
    private Integer capacity;
    @NotNull
    private String instructor;
    @NotNull
    private String type;
    @NotNull
    private String level;
    @NotNull
    private String room;
    @NotNull
    private  Integer coachId;
    @NotNull
    private Integer companyId;

}

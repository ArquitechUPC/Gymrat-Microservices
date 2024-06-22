package org.Arquitech.Gymrat.trainer_service.Trainer.mapping.trainer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("trainerMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TrainerMapper trainerMapper(){ return new TrainerMapper(); }
}

package br.com.pedrohqo.safehealth.infrastructure.config;

import br.com.pedrohqo.safehealth.application.ports.ConsultationRepositoryPort;
import br.com.pedrohqo.safehealth.application.usecases.ScheduleConsultationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsultationConfig {

    @Bean
    public ScheduleConsultationUseCase scheduleConsultationUseCase(ConsultationRepositoryPort repositoryPort){
        return new ScheduleConsultationUseCase(repositoryPort);
    }
}

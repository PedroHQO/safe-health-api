package br.com.pedrohqo.safehealth.application.usecases;

import br.com.pedrohqo.safehealth.application.ports.ConsultationRepositoryPort;
import br.com.pedrohqo.safehealth.domain.Consultation;
import br.com.pedrohqo.safehealth.infrastructure.web.dto.ScheduledConsultationRequest;

import java.time.LocalDateTime;
import java.util.UUID;

public class ScheduleConsultationUseCase {

    private final ConsultationRepositoryPort consultationRepositoryPort;

    public ScheduleConsultationUseCase(ConsultationRepositoryPort consultationRepositoryPort) {
        this.consultationRepositoryPort = consultationRepositoryPort;
    }

    public Consultation execute(UUID patientId, UUID doctorId, LocalDateTime dateTime){
        Consultation consultation = new Consultation(patientId, doctorId, dateTime);
        return consultationRepositoryPort.save(consultation);
    }
}

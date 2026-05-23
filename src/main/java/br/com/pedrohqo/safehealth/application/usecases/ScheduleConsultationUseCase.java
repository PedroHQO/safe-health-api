package br.com.pedrohqo.safehealth.application.usecases;

import br.com.pedrohqo.safehealth.application.ports.ConsultationRepositoryPort;
import br.com.pedrohqo.safehealth.domain.Consultation;
import br.com.pedrohqo.safehealth.domain.InsuranceType;
import br.com.pedrohqo.safehealth.domain.strategies.HealthInsuranceFactory;
import br.com.pedrohqo.safehealth.domain.strategies.HealthInsuranceStrategy;
import br.com.pedrohqo.safehealth.infrastructure.web.dto.ScheduledConsultationRequest;

import java.time.LocalDateTime;
import java.util.UUID;

public class ScheduleConsultationUseCase {

    private final ConsultationRepositoryPort consultationRepositoryPort;

    public ScheduleConsultationUseCase(ConsultationRepositoryPort consultationRepositoryPort) {
        this.consultationRepositoryPort = consultationRepositoryPort;
    }

    public Consultation execute(UUID patientId, UUID doctorId, LocalDateTime dateTime, InsuranceType insuranceType){
        Consultation consultation = new Consultation(patientId, doctorId, dateTime, insuranceType);
        HealthInsuranceStrategy strategy = HealthInsuranceFactory.getStategy(insuranceType);
        strategy.validate(consultation);

        return consultationRepositoryPort.save(consultation);
    }
}

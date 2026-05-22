package br.com.pedrohqo.safehealth.infrastructure.adapters;

import br.com.pedrohqo.safehealth.application.ports.ConsultationRepositoryPort;
import br.com.pedrohqo.safehealth.domain.Consultation;
import br.com.pedrohqo.safehealth.infrastructure.persistence.entities.ConsultationEntity;
import br.com.pedrohqo.safehealth.infrastructure.persistence.repositories.ConsultationJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConsultationRepositoryAdapter implements ConsultationRepositoryPort {

    private final ConsultationJpaRepository consultationJpaRepository;

    public ConsultationRepositoryAdapter(ConsultationJpaRepository consultationJpaRepository) {
        this.consultationJpaRepository = consultationJpaRepository;
    }

    @Override
    public Consultation save(Consultation consultation) {
        ConsultationEntity consultationEntity = new ConsultationEntity();

        consultationEntity.setId(consultation.getId());
        consultationEntity.setPatientId(consultation.getPatientId());
        consultationEntity.setDoctorId(consultation.getDoctorId());
        consultationEntity.setAppointmentDate(consultation.getAppointmentDate());
        consultationEntity.setStatus(consultation.getStatus());

        consultationJpaRepository.save(consultationEntity);
        return consultation;
    }
}

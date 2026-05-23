package br.com.pedrohqo.safehealth.infrastructure.web.dto;

import br.com.pedrohqo.safehealth.domain.InsuranceType;

import java.time.LocalDateTime;
import java.util.UUID;

public record ScheduledConsultationRequest(
        UUID patientId,
        UUID doctorId,
        LocalDateTime appointmentDate,
        InsuranceType insuranceType
) {
}

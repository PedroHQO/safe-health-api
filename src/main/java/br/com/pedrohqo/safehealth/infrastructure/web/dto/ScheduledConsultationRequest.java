package br.com.pedrohqo.safehealth.infrastructure.web.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ScheduledConsultationRequest(
        UUID patientId,
        UUID doctorId,
        LocalDateTime appointmentDate
) {
}

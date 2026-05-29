package br.com.pedrohqo.safehealth.infrastructure.messaging.events;

import java.time.LocalDateTime;
import java.util.UUID;

public record ConsultationScheduledEvent(
        UUID consultationId,
        UUID patientId,
        LocalDateTime appointmentDate
) {
}

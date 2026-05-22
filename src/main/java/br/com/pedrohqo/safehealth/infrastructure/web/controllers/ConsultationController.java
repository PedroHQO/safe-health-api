package br.com.pedrohqo.safehealth.infrastructure.web.controllers;

import br.com.pedrohqo.safehealth.application.usecases.ScheduleConsultationUseCase;
import br.com.pedrohqo.safehealth.domain.Consultation;
import br.com.pedrohqo.safehealth.infrastructure.web.dto.ScheduledConsultationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {

    private final ScheduleConsultationUseCase scheduleConsultationUseCase;

    public ConsultationController(ScheduleConsultationUseCase scheduleConsultationUseCase) {
        this.scheduleConsultationUseCase = scheduleConsultationUseCase;
    }

    @PostMapping
    public ResponseEntity<Consultation> schedule(@RequestBody ScheduledConsultationRequest request){
        Consultation consultation = scheduleConsultationUseCase.execute(
                request.patientId(),
                request.doctorId(),
                request.appointmentDate());

        return ResponseEntity.status(HttpStatus.CREATED).body(consultation);
    }
}

package br.com.pedrohqo.safehealth.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Consultation {
    private UUID id;
    private UUID patientId;
    private UUID doctorId;
    private LocalDateTime appointmentDate;
    private ConsultationStatus status;
    private InsuranceType type;

    public Consultation(UUID patient, UUID doctorId, LocalDateTime dateHour, InsuranceType type) {
        validateFutureDate(dateHour);
        this.id = UUID.randomUUID();
        this.patientId = patient;
        this.doctorId = doctorId;
        this.appointmentDate = dateHour;
        this.status = ConsultationStatus.SHEDULED;
        this.type = type;
    }

    private void validateFutureDate(LocalDateTime date){
        if (date.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("A consulta deve ser marcada para uma data futura!");
        }
    }

    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatientId() {
        return patientId;
    }

    private void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    private void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    private void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public ConsultationStatus getStatus() {
        return status;
    }

    private void setStatus(ConsultationStatus status) {
        this.status = status;
    }
}

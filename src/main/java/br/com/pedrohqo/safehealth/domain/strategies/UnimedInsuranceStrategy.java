package br.com.pedrohqo.safehealth.domain.strategies;

import br.com.pedrohqo.safehealth.domain.Consultation;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UnimedInsuranceStrategy implements HealthInsuranceStrategy{

    @Override
    public void validate(Consultation consultation) {
        LocalDateTime dateNow = LocalDateTime.now();
        LocalDateTime dateConsultation = consultation.getAppointmentDate();
        long hours = ChronoUnit.HOURS.between(dateNow, dateConsultation);

        if(hours < 24){
            throw new IllegalArgumentException("A Unimed exige agendamento com no mínimo 24 horas de antecedência!");
        }
    }
}

package br.com.pedrohqo.safehealth.application.ports;

import br.com.pedrohqo.safehealth.domain.Consultation;

public interface ConsultationRepositoryPort {
    Consultation save(Consultation consultation);
}

package br.com.pedrohqo.safehealth.domain.strategies;

import br.com.pedrohqo.safehealth.domain.Consultation;

public interface HealthInsuranceStrategy {
    void validate(Consultation consultation);
}

package br.com.pedrohqo.safehealth.domain.strategies;

import br.com.pedrohqo.safehealth.domain.Consultation;

public class PrivateInsuranceStrategy implements HealthInsuranceStrategy{

    @Override
    public void validate(Consultation consultation) {
        System.out.println("Consulta particular liberada");

    }
}

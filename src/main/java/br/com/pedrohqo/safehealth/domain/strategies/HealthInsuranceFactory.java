package br.com.pedrohqo.safehealth.domain.strategies;

import br.com.pedrohqo.safehealth.domain.InsuranceType;


public class HealthInsuranceFactory {

    public static HealthInsuranceStrategy getStategy(InsuranceType type){
        return switch (type){
            case PRIVATE -> new PrivateInsuranceStrategy();
            case UNIMED -> new UnimedInsuranceStrategy();
            case BRADESCO -> new PrivateInsuranceStrategy();
            default -> throw new IllegalArgumentException("Tipo de convênio não suportado ou inválido");
        };

    }
}

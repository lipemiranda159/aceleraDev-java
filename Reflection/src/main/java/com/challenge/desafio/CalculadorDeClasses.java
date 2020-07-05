package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;
import com.challenge.services.DataExtractorService;

import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {
    @Override
    public BigDecimal somar(Object obj) {
        return DataExtractorService.GetSumValues(Somar.class, obj);
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        return DataExtractorService.GetSumValues(Subtrair.class, obj);
    }

    @Override
    public BigDecimal totalizar(Object obj) {
        BigDecimal sumSomar = somar(obj);
        BigDecimal sumSubtrair = subtrair(obj);
        return sumSomar.subtract(sumSubtrair);
    }
}

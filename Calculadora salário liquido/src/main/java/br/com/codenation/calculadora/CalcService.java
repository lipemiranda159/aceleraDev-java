package br.com.codenation.calculadora;

public class CalcService {
    public static final double calcularDesconto(double salarioBase, ListRange listRange) {
        double percent = listRange.getPercent(salarioBase);
        return percent > 0 ? salarioBase - (salarioBase *(percent/100)) : salarioBase;
    }

}

package br.com.codenation.calculadora;


public class CalculadoraSalario {
	private ListInssRange InssRange = new ListInssRange();
	private ListIprfRange IprfRange = new ListIprfRange();

	public boolean IsSalValid(double salario){
		if (salario < Constant.Minimum){
			return false;
		}
		else {
			return  true;
		}
	}
	public long calcularSalarioLiquido(double salarioBase) {
		if (!IsSalValid(salarioBase)){
			return Math.round(0.0);
		}
		salarioBase = CalcService.calcularDesconto(salarioBase, InssRange);
		salarioBase = CalcService.calcularDesconto(salarioBase, IprfRange);

		return Math.round(salarioBase);
	}
}

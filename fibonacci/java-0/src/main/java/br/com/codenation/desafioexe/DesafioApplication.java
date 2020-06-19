package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static final List<Integer> FibonacciList = fibonacci();
	public static List<Integer> fibonacci() {
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		int actualNumber = Consts.FIRST_FIBONACCI_NUMBER;
		int nextNumber = Consts.SECOND_FIBONACCI_NUMBER;
		int aux = Consts.FIRST_FIBONACCI_NUMBER;
		while (nextNumber < Consts.LIMIT_FIBONACCI_NUMBER){
			aux = actualNumber + nextNumber;
			nextNumber = actualNumber;
			actualNumber = aux;
			resultList.add(nextNumber);
		}
		return resultList;
	}

	public static Boolean isFibonacci(Integer a) {
		return FibonacciList.contains(a);
	}
}
package br.com.codenation.calculadora;

public class ListInssRange extends ListRange {

    ListInssRange(){
        ListRange.add(new Range(0, 1500, 8));
        ListRange.add(new Range(1500.01, 4000, 9));
        ListRange.add(new Range(4000F, Double.MAX_VALUE, 11));
    }

}

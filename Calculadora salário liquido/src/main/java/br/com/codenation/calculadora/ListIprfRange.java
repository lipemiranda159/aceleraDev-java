package br.com.codenation.calculadora;

public class ListIprfRange extends ListRange {
    ListIprfRange(){
        ListRange.add(new Range(0, 3000, 0));
        ListRange.add(new Range(3000.01, 6000, 7.5));
        ListRange.add(new Range(6000F, Double.MAX_VALUE, 15));
    }
}

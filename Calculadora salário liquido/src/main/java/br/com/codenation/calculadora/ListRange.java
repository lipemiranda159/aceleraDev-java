package br.com.codenation.calculadora;

import java.util.ArrayList;

public class ListRange {
    public ArrayList<Range> ListRange = new ArrayList<Range>();

    public double getPercent(double value){

        double percent = 0;
        for (Range range: ListRange) {
            if (value >= range.Start && value <= range.Finish)
            {
                percent = range.Percent;
                break;
            }
        }
f        return percent;
    }
}

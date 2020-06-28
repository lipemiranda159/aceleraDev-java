package br.com.codenation;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StatisticUtil {

	public static int average(int[] elements) {
		ArrayService.TamanhoValido(elements);
		return (int)Math.round(Arrays.stream(elements).average().orElse(Double.NaN));
	}

	public static int mode(int[] elements) {
		ArrayService.TamanhoValido(elements);
			ArrayList<Element> elementsList = ArrayService.CriaElementList(elements);
			return elementsList
					.stream()
					.sorted((element1, element2) -> Long.compare(element2.getCount(), element1.getCount()))
					.collect(toList()).get(0)
					.getValue();

	}

	public static int median(int[] elements) {

		ArrayService.TamanhoValido(elements);
		Arrays.sort(elements);
		if (elements.length % 2 == 0)
		{
			int PosMeio = elements.length/2;
			int media =  MediaDoisValores(elements[PosMeio], elements[PosMeio-1]);
			return media;
		} else {
			return elements[elements.length / 2];
		}

	}

	private static int MediaDoisValores(int val1, int val2) {
		return (val1 + val2)/2;
	}


}
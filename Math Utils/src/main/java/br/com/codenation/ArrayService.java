package br.com.codenation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayService {
    public static ArrayList<Element> CriaElementList(int[] elements)
    {
        ArrayList<Element> elementsList = new ArrayList<Element>();
        for (int pos = 0; pos < elements.length; pos++)
        {
            int value = elements[pos];
            try {
                elementsList
                        .stream()
                        .filter(element -> element.getValue() == value)
                        .findAny()
                        .orElseThrow(Error::new)
                        .IncrementCount();
            } catch (Error ex)
            {
                elementsList.add(new Element(value));
            }
        }
        return elementsList;
    }

    public static void TamanhoValido(int[] elements)
    {
        if (elements.length <= 0)
            throw new IllegalArgumentException("Tamanho do vetor é inválido");
    }

}

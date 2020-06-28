package br.com.codenation.db;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

class EntityRepository<T> {

    private final ArrayList<T> List;

    EntityRepository(ArrayList<T> list) {
        List = list;
    }


    public Stream<T> FiltraLista(Predicate<T> predicado)
    {
        return  List
                .stream()
                .filter(predicado);
    }

    public Stream<T> GetListStream()
    {
        return List.stream();
    }
}

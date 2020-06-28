package br.com.codenation.db;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TimeRepositorio extends EntityRepository<Time> {
    private final DbService dbService;
    private final JogadorRepositorio jogadorRepositorio;


    private Time BuscaTime(Long idTime){
        ArrayList<Time> times;
        times = (ArrayList<Time>) FiltraLista(j -> j.getId().equals(idTime))
                .collect(Collectors.toList());
        if (times.size() > 0) {
            return times.get(0);
        } else {
            throw new TimeNaoEncontradoException();
        }

    }

    private ArrayList<Jogador> BuscarJogadores(Long idTime){
        BuscaTime(idTime);
        ArrayList<Jogador> jogadores = jogadorRepositorio.BuscarJogadoresTime(idTime);
        return  jogadores;
    }

    public TimeRepositorio(DbService dbService) {
        super(dbService.getTimes());
        this.dbService = dbService;
        this.jogadorRepositorio = new JogadorRepositorio(dbService, this);
    }


    public void AdicionarTime(Time time){
        try{
            Time getTime = BuscaTime(time.getId());
            if (getTime != null)
            {
                throw new IdentificadorUtilizadoException();
            }
        } catch (TimeNaoEncontradoException ex)
        {
            dbService.getTimes().add(time);
        }
    }
    public String BuscarNomeTime(Long idTime){
        Time time = BuscaTime(idTime);
        return time.getNome();
    }

    public void DefinirCapitao(Long idJogador)
    {
        Jogador jogador = jogadorRepositorio.BuscaJogador(idJogador);
        Time time = BuscaTime(jogador.getIdTime());
        time.setIdCapitao(idJogador);
        ArrayList<Time> times = dbService.getTimes();
        int pos = times.indexOf(time);
        times.set(pos,time);
    }

    public Long BuscaCapitao(Long idTime)
    {
        Time time = BuscaTime(idTime);
        return time.getIdCapitao();
    }

    public ArrayList<Long> BuscaIdsJogadoresTime(Long idTime){
       ArrayList<Jogador> jogadores =  BuscarJogadores(idTime);
       return jogadorRepositorio.GetIds(jogadores);
    }

    public Long BuscaMelhorJogador(Long idTime){
        ArrayList<Jogador> jogadores =  BuscarJogadores(idTime);
        return jogadores
                .stream()
                .max(Comparator.comparing(Jogador::getNivelHabilidade))
                .get().getId();
    }
    public Long BuscaJogadorMaisVelho(Long idTime){
        ArrayList<Jogador> jogadores =  BuscarJogadores(idTime);
        return jogadores
                .stream()
                .max(Comparator.comparing(Jogador::getIdade))
                .get().getId();
    }

    public ArrayList<Long> BuscaTimes()
    {
        return (ArrayList<Long>) dbService
                .getTimes()
                .stream()
                .sorted(Comparator.comparing(Time::getId))
                .map(time -> time.getId()).collect(Collectors.toList());
    }
    public Long BuscaJogadorMaiorSalario(Long idTime){
        ArrayList<Jogador> jogadores =  BuscarJogadores(idTime);
        return jogadores
                .stream()
                .max(Comparator.comparing(Jogador::getSalario))
                .get().getId();
    }

}

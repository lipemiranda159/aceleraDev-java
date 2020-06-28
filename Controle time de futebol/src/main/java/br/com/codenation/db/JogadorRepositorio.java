package br.com.codenation.db;

import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class JogadorRepositorio extends EntityRepository<Jogador> {
    private final DbService dbService;
    private final TimeRepositorio timeRepositorio;

    public Jogador BuscaJogador(Long idJogador){
        ArrayList<Jogador> jogadores;
        jogadores = (ArrayList<Jogador>) FiltraLista(j -> j.getId().equals(idJogador)).collect(Collectors.toList());
        if (jogadores.size() > 0) {
            return jogadores.get(0);
        } else {
            throw new JogadorNaoEncontradoException();
        }

    }

    public JogadorRepositorio(DbService dbService, TimeRepositorio timeRepositorio) {
        super(dbService.getJogadores());
        this.dbService = dbService;
        this.timeRepositorio = timeRepositorio;
    }


    public void AdicionarJogador(Jogador jogador){
        try {
            BuscaJogador(jogador.getId());
            throw new IdentificadorUtilizadoException();
        } catch (JogadorNaoEncontradoException ex) {
            timeRepositorio.BuscarNomeTime(jogador.getIdTime());
            dbService.getJogadores().add(jogador);
        }
    }
    public String BuscarNomeJogador(Long idJogador){
        Jogador jogador = BuscaJogador(idJogador);
        return jogador.getNome();
    }
    public BigDecimal BuscaSalarioJogador(Long idJogador) {
        Jogador jogador = BuscaJogador(idJogador);
        return jogador.getSalario();
    }

    public ArrayList<Long> GetIds(ArrayList<Jogador> jogadores)
    {
        return (ArrayList<Long>) jogadores.stream().map(Jogador::getId).collect(Collectors.toList());
    }

    public ArrayList<Jogador> BuscarJogadoresTime(Long idTime){
        ArrayList<Jogador> result =
                (ArrayList<Jogador>) FiltraLista(
                        j -> j.getIdTime()
                                .equals(idTime)).collect(Collectors.toList());

        if (result.size() > 0)
        {
            return  result;
        } else {
            throw new TimeNaoEncontradoException();
        }
    }

    public ArrayList<Long> Top(int take)
    {
        return (ArrayList<Long>) GetListStream()
                .sorted((jogador1, jogador2) -> Long.compare(jogador2.getId(), jogador1.getId()))
                .limit(take)
                .map(Jogador::getId).collect(Collectors.toList());
    }
}

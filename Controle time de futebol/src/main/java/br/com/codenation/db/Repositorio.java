package br.com.codenation.db;

public class Repositorio {
    private final JogadorRepositorio jogadorRepositorio;

    public Repositorio() {
        DbService dbService = new DbService();
        this.timeRepositorio = new TimeRepositorio(dbService);
        this.jogadorRepositorio = new JogadorRepositorio(dbService, this.timeRepositorio);

    }

    public JogadorRepositorio getJogadorRepositorio() {
        return jogadorRepositorio;
    }

    public TimeRepositorio getTimeRepositorio() {
        return timeRepositorio;
    }

    private TimeRepositorio timeRepositorio;
}

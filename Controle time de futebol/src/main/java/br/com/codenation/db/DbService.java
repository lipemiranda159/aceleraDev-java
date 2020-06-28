package br.com.codenation.db;

import br.com.codenation.db.Jogador;
import br.com.codenation.db.Time;

import java.util.ArrayList;

class DbService {
    private ArrayList<Jogador> Jogadores;

    public ArrayList<Jogador> getJogadores() {
        return Jogadores;
    }

    public ArrayList<Time> getTimes() {
        return Times;
    }

    private ArrayList<Time> Times;

    public DbService() {
        Jogadores = new ArrayList<Jogador>();
        Times = new ArrayList<Time>();
    }
}

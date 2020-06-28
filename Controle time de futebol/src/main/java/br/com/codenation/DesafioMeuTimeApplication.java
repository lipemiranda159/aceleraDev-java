package br.com.codenation;

import br.com.codenation.db.Jogador;
import br.com.codenation.db.Repositorio;
import br.com.codenation.db.Time;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private final Repositorio repositorio;

	public DesafioMeuTimeApplication() {
		repositorio = new Repositorio();
	}

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		Time time = new Time(id,nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		repositorio.getTimeRepositorio().AdicionarTime(time);
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		repositorio.getJogadorRepositorio().AdicionarJogador(jogador);
	}

	public void definirCapitao(Long idJogador) {
		repositorio.getTimeRepositorio().DefinirCapitao(idJogador);
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		return repositorio.getTimeRepositorio().BuscaCapitao(idTime);
	}

	public String buscarNomeJogador(Long idJogador) {
		return  repositorio.getJogadorRepositorio().BuscarNomeJogador(idJogador);
	}

	public String buscarNomeTime(Long idTime) {
		return repositorio.getTimeRepositorio().BuscarNomeTime(idTime);
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		return repositorio.getTimeRepositorio().BuscaIdsJogadoresTime(idTime);
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		return repositorio.getTimeRepositorio().BuscaMelhorJogador(idTime);
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		return repositorio.getTimeRepositorio().BuscaJogadorMaisVelho(idTime);
	}

	public List<Long> buscarTimes() {
		return repositorio.getTimeRepositorio().BuscaTimes();
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		return repositorio.getTimeRepositorio().BuscaJogadorMaiorSalario(idTime);
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return repositorio.getJogadorRepositorio().BuscaSalarioJogador(idJogador);
	}

	public List<Long> buscarTopJogadores(Integer top) {
		return repositorio.getJogadorRepositorio().Top(top);
	}

}

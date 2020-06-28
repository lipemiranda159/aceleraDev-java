package br.com.codenation.db;

import br.com.codenation.exceptions.DataNascimentoInvalidoException;
import br.com.codenation.exceptions.NivelHabilidadeInvalidaException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public int getIdade(){
        return LocalDate.now().getYear() - dataNascimento.getYear();
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento.isAfter(LocalDate.now()))
        {
            throw new DataNascimentoInvalidoException();
        }
        this.dataNascimento = dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        if (nivelHabilidade < 0 || nivelHabilidade > 100)
        {
            throw new NivelHabilidadeInvalidaException();
        }
        this.nivelHabilidade = nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    private Long id;
    private Long idTime;
    private String nome;
    private LocalDate dataNascimento;

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        setId(id);
        setIdTime(idTime);
        setNome(nome);
        setDataNascimento(dataNascimento);
        setNivelHabilidade(nivelHabilidade);
        setSalario(salario);
    }

    private Integer nivelHabilidade;
    private BigDecimal salario;
}

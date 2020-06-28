package br.com.codenation.db;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.DataNascimentoInvalidoException;

import java.time.LocalDate;

public class Time {
    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private Long idCapitao;

    public Long getIdCapitao() {
        if (idCapitao != null) {
            return idCapitao;
        } else {
            throw new CapitaoNaoInformadoException();
        }
    }


    public void setIdCapitao(Long idCapitao) {
        this.idCapitao = idCapitao;
    }

    public Time(Long id, String nome, LocalDate dataCriacaoo, String corUniformePrincipal, String corUniformeSecundario) {
        setId(id);
        setNome(nome);
        setDataCriacao(dataCriacaoo);
        setCorUniformePrincipal(corUniformePrincipal);
        setCorUniformeSecundario(corUniformeSecundario);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        if (dataCriacao.isAfter(LocalDate.now()))
        {
            throw new DataNascimentoInvalidoException();
        }
        this.dataCriacao = dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public void setCorUniformePrincipal(String corUniformePrincipal) {
        this.corUniformePrincipal = corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public void setCorUniformeSecundario(String corUniformeSecundario) {
        this.corUniformeSecundario = corUniformeSecundario;
    }

    private String corUniformeSecundario;

}

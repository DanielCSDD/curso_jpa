package com.curso.jpa.web.bean.auxiliar;

import com.curso.jpa.model.Funcionario;
import com.curso.jpa.service.ServicoFuncionario;

import javax.ejb.EJB;
import javax.persistence.EntityManager;

public class Sessao {

    private String sessao;

    private Funcionario funcionario;

    private String editarNome;

    @EJB
    private ServicoFuncionario servicoFuncionario;

    public Sessao(String sessao, Funcionario funcionario) {
        this.sessao = sessao;
        this.funcionario = funcionario;
    }

    public String getSessao() {
        return sessao;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    public String getEditarNome() {
        return editarNome;
    }

    public void setEditarNome(String editarNome) {
        this.editarNome = editarNome;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}

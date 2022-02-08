package com.curso.jpa.service;

import com.curso.jpa.dao.FuncionarioDAO;
import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.model.Funcionario;
import com.curso.jpa.service.generico.ServicoComum;
import com.curso.jpa.web.bean.auxiliar.Sessao;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ServicoFuncionario extends ServicoComum<Funcionario, Long> {

    @EJB
    private FuncionarioDAO dao;

    @Override
    public GenericDAO<Funcionario, Long> getEntidadeDAO() {
        return this.dao;
    }

    public Funcionario abreSessaoFuncionario(){
        return this.dao.buscaFuncionario();
    }

    public Funcionario atualizarDados(Sessao funcionario){
        return this.dao.atualizarDados(funcionario);
    }

    public void verificaAtualizarDados(Sessao funcionario){
        this.dao.verificaAtualizarDados(funcionario);
    }
}

package com.curso.jpa.service;

import com.curso.jpa.dao.ConfiguracaoDAO;
import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.model.Configuracao;
import com.curso.jpa.service.generico.ServicoComum;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ServicoConfiguracao extends ServicoComum<Configuracao, Long> {

    @EJB
    private ConfiguracaoDAO dao;

    @Override
    public GenericDAO<Configuracao, Long> getEntidadeDAO() {
        return this.dao;
    }
}

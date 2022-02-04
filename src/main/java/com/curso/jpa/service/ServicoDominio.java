package com.curso.jpa.service;

import com.curso.jpa.dao.DominioDAO;
import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.model.Dominio;
import com.curso.jpa.service.generico.ServicoComum;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ServicoDominio extends ServicoComum<Dominio, Long> {

    @EJB
    private DominioDAO dao;

    @Override
    public GenericDAO<Dominio, Long> getEntidadeDAO() {
        return this.dao;
    }

    public Dominio buscaPorUsuario(Integer id){
        return this.dao.buscaPorUsuario(id);
    }
}

package com.curso.jpa.service;

import com.curso.jpa.dao.ArtigoDAO;
import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.model.Artigo;
import com.curso.jpa.service.generico.ServicoComum;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.*;

@Stateless
public class ServicoArtigo extends ServicoComum<Artigo, Long> {

    @EJB
    private ArtigoDAO dao;

    @Override
    public GenericDAO<Artigo, Long> getEntidadeDAO() {
        return this.dao;
    }

    public Artigo buscarArtigo() {
        return this.dao.buscarArtigo();
    }

    public Artigo alterar(Artigo artigo){
        return this.dao.alterar(artigo);
    }

    public void javaEOBancoDados(Artigo artigo){
        this.dao.javaEOBancoDados(artigo);
    }

    public void casoMaisPratico(Artigo artigo){
        this.dao.casoMaisPratico(artigo);
    }
}

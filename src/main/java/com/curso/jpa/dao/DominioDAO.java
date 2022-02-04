package com.curso.jpa.dao;

import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.model.Dominio;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

@Stateless
public class DominioDAO extends GenericDAO<Dominio, Long> {

    /**
     * Consultando tabela: DOMINIO por parâmetro
     */
    public Dominio buscaPorUsuario(Integer id){
        String jpql = "select u.dominio from Usuario u where u.id = :id";
        TypedQuery<Dominio> query = getEntityManager().createQuery(jpql, Dominio.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}

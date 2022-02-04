package com.curso.jpa.dao;

import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.model.Dominio;
import com.curso.jpa.model.Usuario;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateless
public class DominioDAO extends GenericDAO<Dominio, Long> {

    private CriteriaBuilder criteriaBuilder;

    /**
     * Consultando tabela: DOMINIO por parâmetro
     */
    public Dominio buscaPorUsuario(Integer id){
        String jpql = "select u.dominio from Usuario u where u.id = :id";
        TypedQuery<Dominio> query = getEntityManager().createQuery(jpql, Dominio.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    /**
     * Consultando tabela: USUARIO com CriteriaQuery
     */
    public List<Dominio> buscaDominiosPorUsuarioComCriteriaQuery(){
        this.criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Dominio> query = this.criteriaBuilder.createQuery(Dominio.class);
        Root<Usuario> root = query.from(Usuario.class);
        query.select(root.get("dominio"));
        TypedQuery<Dominio> typedQuery = getEntityManager().createQuery(query);
        return typedQuery.getResultList();
    }
}

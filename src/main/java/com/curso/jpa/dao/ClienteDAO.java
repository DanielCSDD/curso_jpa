package com.curso.jpa.dao;

import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.model.Cliente;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ClienteDAO extends GenericDAO<Cliente, Long> {

    public Cliente buscarCliente(){
        String jpql = " FROM Cliente c WHERE c.id = 1";

        TypedQuery<Cliente> query = getEntityManager().createQuery(jpql, Cliente.class);

        return query.getSingleResult();
    }

    /**
     * Para dar certo deverá comentar o trecho de código referente aos inserts
     * na tabela. Pois dá conflito ao tentar persistir dados com a tabela populado pelo arquivo.
     */
    public Cliente inserirCliente(Cliente cliente){
        getEntityManager().persist(cliente);
        return cliente;
    }

    public Cliente inserirClienteMerge(Cliente cliente){
        getEntityManager().merge(cliente);
        return cliente;
    }

    public void removerCliente(Cliente cliente){
        getEntityManager().remove(getEntityManager().contains(cliente) ? cliente : getEntityManager().merge(cliente));
    }

    public Cliente atualizarCliente(Cliente cliente){
        cliente = getEntityManager().merge(cliente);
        return cliente;
    }

    public List<Cliente> buscarClientes(){
        String jpql = " FROM Cliente c";

        TypedQuery<Cliente> query = getEntityManager().createQuery(jpql, Cliente.class);

        return query.getResultList();
    }
}

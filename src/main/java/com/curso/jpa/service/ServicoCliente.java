package com.curso.jpa.service;

import com.curso.jpa.dao.ClienteDAO;
import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.model.Cliente;
import com.curso.jpa.service.generico.ServicoComum;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ServicoCliente extends ServicoComum<Cliente, Long> {

    @EJB
    private ClienteDAO dao;

    @Override
    public GenericDAO<Cliente, Long> getEntidadeDAO() {
        return dao;
    }

    public List<Cliente> buscarClientes(){
        return this.dao.buscarClientes();
    }

    public Cliente inserirCliente(Cliente cliente){
        return this.dao.inserirCliente(cliente);
    }

    public Cliente inserirClienteMerge(Cliente cliente){
        return this.dao.inserirClienteMerge(cliente);
    }
    public Cliente buscarCliente(){
        return this.dao.buscarCliente();
    }

    public void removerCliente(Cliente cliente){
        this.dao.removerCliente(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente){
        return this.dao.atualizarCliente(cliente);
    }
}

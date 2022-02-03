package com.curso.jpa.web.bean;

import com.curso.jpa.model.Cliente;
import com.curso.jpa.service.generico.ServicoCliente;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import java.util.List;

@Named
@ManagedBean
public class BeanTeste {

    @EJB
    private ServicoCliente servicoCliente;

    private static boolean executou;

    public void init() {
        if (!executou) {
            cliente();
            executou = true;
        }
    }

    public void cliente() {
//        carregarCliente();
//        inserirCliente();
//        inserirClienteMerge();
//        removerCliente();
//        atualizarCliente();
        carregarListaClientes();
    }

    private void atualizarCliente() {
        Cliente atualizar = this.servicoCliente.buscarCliente();
        atualizar.setNome("Atualizado");
        atualizar = this.servicoCliente.atualizarCliente(atualizar);
    }

    private void carregarListaClientes() {
        List<Cliente> clientes = this.servicoCliente.buscarClientes();
    }

    private void removerCliente() {
        Cliente remover = this.servicoCliente.buscarCliente();
        this.servicoCliente.removerCliente(remover);
    }

    private void inserirCliente() {
        Cliente novo = new Cliente();
        novo.setNome("Armazém Feliz!");
        novo = this.servicoCliente.inserirCliente(novo);
    }

    private void inserirClienteMerge() {
        Cliente novo = new Cliente();
        novo.setNome("Armazém Novo!");
        novo = this.servicoCliente.inserirClienteMerge(novo);
    }

    private void carregarCliente() {
        Cliente cliente = this.servicoCliente.buscarCliente();
    }
}

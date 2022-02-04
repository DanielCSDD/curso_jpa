package com.curso.jpa.web.bean;

import com.curso.jpa.dto.UsuarioDTO;
import com.curso.jpa.model.Cliente;
import com.curso.jpa.model.Dominio;
import com.curso.jpa.model.Usuario;
import com.curso.jpa.service.ServicoCliente;
import com.curso.jpa.service.ServicoDominio;
import com.curso.jpa.service.ServicoUsuario;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;
import java.util.List;

@Named
@ManagedBean
public class BeanTeste {

    @EJB
    private ServicoCliente servicoCliente;

    @EJB
    private ServicoUsuario servicoUsuario;

    @EJB
    private ServicoDominio servicoDominio;

    private static boolean executou;

    public void init() {
        if (!executou) {
            cliente();
            usuario();
            dominio();
            executou = true;
        }
    }

    private void dominio() {
        carregarDominioPorUsuario();
    }

    private void carregarDominioPorUsuario() {
        Dominio dominio = this.servicoDominio.buscaPorUsuario(1);
    }

    private void usuario() {
        carregarListaUsuarios();
        carregarUsuarioConsultaSemTipo();
        carregarUsuario();
        carregarUsuarioProProjecao();
        carregarUsuarioProProjecaoDTO();
        carregarNomeUsuarios();
    }

    private void carregarUsuarioProProjecaoDTO() {
        List<UsuarioDTO> usuarios = this.servicoUsuario.buscaPorProjecaoDTO();
    }

    private void carregarNomeUsuarios() {
        List<String> usuarios = this.servicoUsuario.buscaNomesUsuarios();
    }

    private void carregarUsuarioProProjecao() {
        List<Object[]> usuarios = this.servicoUsuario.buscaPorProjecao();
    }

    private void carregarUsuario() {
        Usuario usuario = this.servicoUsuario.buscaPorId(1);
    }

    private void carregarUsuarioConsultaSemTipo() {
        Usuario usuario = this.servicoUsuario.buscaPorIdSemTipo(1);
    }

    private void carregarListaUsuarios() {
        List<Usuario> usuarios = this.servicoUsuario.buscaListaUsuarios();
    }

    public void cliente() {
        carregarCliente();
        inserirCliente();
        inserirClienteMerge();
        removerCliente();
        atualizarCliente();
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

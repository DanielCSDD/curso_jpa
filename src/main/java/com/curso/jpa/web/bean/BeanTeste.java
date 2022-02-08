package com.curso.jpa.web.bean;

import com.curso.jpa.dto.UsuarioDTO;
import com.curso.jpa.model.*;
import com.curso.jpa.service.*;
import com.curso.jpa.web.bean.auxiliar.Sessao;

import javax.annotation.ManagedBean;
import javax.ejb.*;
import javax.inject.Named;
import java.util.List;

@Named
@ManagedBean
//@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class BeanTeste {

    @EJB
    private ServicoCliente servicoCliente;

    @EJB
    private ServicoUsuario servicoUsuario;

    @EJB
    private ServicoDominio servicoDominio;

    @EJB
    private ServicoFuncionario servicoFuncionario;

    @EJB
    private ServicoArtigo servicoArtigo;

    private static boolean executou;

    public void init() {
        if (!executou) {
//            cliente();
//            usuario();
//            dominio();
//            funcionario();
            artigo();
            executou = true;
        }
    }

    private void artigo() {
        Artigo artigo1 = this.servicoArtigo.buscarArtigo();
        artigo1.setNomeEditor("João");
        artigo1.setConteudo(" Artigo atualizado " + artigo1.getNomeEditor());
        artigo1.setNumThread(1);
        Artigo artigo2 = this.servicoArtigo.buscarArtigo();
        artigo2.setNomeEditor("Maria");
        artigo2.setConteudo(" Artigo atualizado " + artigo2.getNomeEditor());
        artigo2.setNumThread(2);

        casoMaisPratico(artigo2);
        casoMaisPratico(artigo1);
//        javaEOBancoDados(artigo2);
//        javaEOBancoDados(artigo1);
    }

    public void casoMaisPratico(Artigo artigo){
        this.servicoArtigo.casoMaisPratico(artigo);
    }

    private void javaEOBancoDados(Artigo artigo) {
        this.servicoArtigo.javaEOBancoDados(artigo);
    }

    private Artigo alterarArtigo(Artigo artigo) {
        return this.servicoArtigo.alterar(artigo);
    }

    private void funcionario() {
        Funcionario funcionario1 = abrindoSessao();
        Funcionario funcionario2 = abrindoSessao();

        String sessao1 = "SESSAO_1";
        String sessao2 = "SESSAO_2";

        Sessao funcionarioSessao1 = new Sessao(sessao1, funcionario1);
        funcionarioSessao1.setEditarNome("Roberto Carlos Pereira Silva");

        Sessao funcionarioSessao2 = new Sessao(sessao2, funcionario2);
        funcionarioSessao2.setEditarNome("Silvara Karter Silva");

        funcionarioSessao1.setFuncionario(submeterFormulario(funcionarioSessao1));
        funcionarioSessao2.setFuncionario(submeterFormulario(funcionarioSessao2));

        verificarAtualizacao(funcionarioSessao1);
        verificarAtualizacao(funcionarioSessao2);
    }
    
    public void verificarAtualizacao(Sessao sessao){
        this.servicoFuncionario.verificaAtualizarDados(sessao);
    }

    public Funcionario submeterFormulario(Sessao sessao) {
        sessao.getFuncionario().setNome(sessao.getEditarNome());
        return this.servicoFuncionario.atualizarDados(sessao);
    }

    private Funcionario abrindoSessao() {
        return this.servicoFuncionario.abreSessaoFuncionario();
    }

    private void dominio() {
        carregarDominioPorUsuario();
        carregarDominioPorUsuarioComCriteriaQuery();
    }

    private void carregarDominioPorUsuarioComCriteriaQuery() {
        List<Dominio> dominios = this.servicoDominio.buscaDominiosPorUsuarioComCriteriaQuery();
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
        carregarUsuarioComDominioJoin();
        carregarUsuarioComDominioLeftJoin();
        carregarUsuarioComDominioFetchJoin();
        carregarUsuarioComFiltro();
        carregarUsuarioComFiltroOperadores();
        carregarUsuarioComOperadorIn();
        carregarUsuarioListaOrdenada();
        carregarUsuarioComPaginacao();
        carregarUsuarioComCriteriaQuery();
        carregarNomesUsuarioComCriteriaQuery();
        carregarUsuarioProProjecaoCriteriaQuery();
        carregarUsuarioProProjecaoDTOCriteriaQuery();
        carregarUsuarioCriteria();
        carregarUsuarioListaOrdenadaCriteria();
        carregarUsuarioComPaginacaoCriteria();
    }

    private void carregarUsuarioComPaginacaoCriteria() {
        List<Usuario> usuarios = this.servicoUsuario.buscaUsuariosListaComPaginacaoCriteria();
    }

    private void carregarUsuarioListaOrdenadaCriteria() {
        List<Usuario> usuarios = this.servicoUsuario.buscaUsuariosListaOrdenadaCriteria();
    }

    private void carregarUsuarioCriteria() {
        Usuario usuario = this.servicoUsuario.buscaPorIdCriteria(1);
    }

    private void carregarUsuarioProProjecaoDTOCriteriaQuery() {
        List<UsuarioDTO> usuarios = this.servicoUsuario.buscaPorProjecaoDTOCriteria();
    }

    private void carregarUsuarioProProjecaoCriteriaQuery() {
        List<Object[]> usuarios = this.servicoUsuario.buscaPorProjecaoCriteria();
    }

    private void carregarNomesUsuarioComCriteriaQuery() {
        List<String> usuarios = this.servicoUsuario.buscaNomesUsuariosComCriteria();
    }

    private void carregarUsuarioComCriteriaQuery() {
        List<Usuario> usuarios = this.servicoUsuario.buscaUsuariosListaComCriteriaQuery();
    }

    private void carregarUsuarioComPaginacao() {
        List<Usuario> usuarios = this.servicoUsuario.buscaUsuariosListaComPaginacao();
    }

    private void carregarUsuarioListaOrdenada() {
        List<Usuario> usuarios = this.servicoUsuario.buscaUsuariosListaOrdenada();
    }

    private void carregarUsuarioComOperadorIn() {
        List<Usuario> usuarios = this.servicoUsuario.buscaUsuariosComOperadorIn();
    }

    private void carregarUsuarioComFiltroOperadores() {
        List<Usuario> usuarios = this.servicoUsuario.buscaUsuariosComFiltroOperadores();
    }

    private void carregarUsuarioComFiltro() {
        List<Usuario> usuarios = this.servicoUsuario.buscaUsuariosComFiltro();
    }

    private void carregarUsuarioComDominioFetchJoin() {
        List<Usuario> usuarios = this.servicoUsuario.buscaUsuariosComConfiguracaoFetchJoin();
    }

    private void carregarUsuarioComDominioLeftJoin() {
        List<Object[]> usuarios = this.servicoUsuario.buscaUsuariosComConfiguracaoLeftJoin();
    }

    private void carregarUsuarioComDominioJoin() {
        List<Usuario> usuarios = this.servicoUsuario.buscaUsuariosComDominioJoin();
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

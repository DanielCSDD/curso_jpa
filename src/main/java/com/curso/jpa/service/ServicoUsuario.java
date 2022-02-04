package com.curso.jpa.service;

import com.curso.jpa.dao.UsuarioDAO;
import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.dto.UsuarioDTO;
import com.curso.jpa.model.Usuario;
import com.curso.jpa.service.generico.ServicoComum;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ServicoUsuario extends ServicoComum<Usuario, Long> {

    @EJB
    private UsuarioDAO dao;

    @Override
    public GenericDAO<Usuario, Long> getEntidadeDAO() {
        return this.dao;
    }

    public List<Usuario> buscaListaUsuarios(){
        return this.dao.buscaListaUsuarios();
    }

    public Usuario buscaPorIdSemTipo(Integer id){
        return this.dao.buscaPorIdSemTipo(id);
    }

    public Usuario buscaPorId(Integer id){
        return this.dao.buscaPorId(id);
    }

    public List<Object[]> buscaPorProjecao(){
        return this.dao.buscaPorProjecao();
    }

    public List<UsuarioDTO> buscaPorProjecaoDTO(){
        return this.dao.buscaPorProjecaoDTO();
    }

    public List<String> buscaNomesUsuarios(){
        return this.dao.buscaNomesUsuarios();
    }

    public List<Usuario> buscaUsuariosComDominioJoin(){
        return this.dao.buscaUsuariosComDominioJoin();
    }

    public List<Object[]> buscaUsuariosComConfiguracaoLeftJoin(){
        return this.dao.buscaUsuariosComConfiguracaoLeftJoin();
    }

    public List<Usuario> buscaUsuariosComConfiguracaoFetchJoin(){
        return this.dao.buscaUsuariosComConfiguracaoFetchJoin();
    }

    public List<Usuario> buscaUsuariosComFiltro(){
        return this.dao.buscaUsuariosComFiltro();
    }

    public List<Usuario> buscaUsuariosComFiltroOperadores(){
        return this.dao.buscaUsuariosComFiltroOperadores();
    }

    public List<Usuario> buscaUsuariosComOperadorIn(){
        return this.dao.buscaUsuariosComOperadorIn();
    }

    public List<Usuario> buscaUsuariosListaOrdenada(){
        return this.dao.buscaUsuariosListaOrdenada();
    }

    public List<Usuario> buscaUsuariosListaComPaginacao(){
        return this.dao.buscaUsuariosListaComPaginacao();
    }

    public List<Usuario> buscaUsuariosListaComCriteriaQuery(){
        return this.dao.buscaUsuariosListaComCriteriaQuery();
    }

    public List<String> buscaNomesUsuariosComCriteria(){
        return this.dao.buscaNomesUsuariosComCriteria();
    }

    public List<Object[]> buscaPorProjecaoCriteria(){
        return this.dao.buscaPorProjecaoCriteria();
    }

    public List<UsuarioDTO> buscaPorProjecaoDTOCriteria(){
        return this.dao.buscaPorProjecaoDTOCriteria();
    }

    public Usuario buscaPorIdCriteria(Integer id){
        return this.dao.buscaPorIdCriteria(id);
    }

    public List<Usuario> buscaUsuariosListaOrdenadaCriteria(){
        return this.dao.buscaUsuariosListaOrdenadaCriteria();
    }

    public List<Usuario> buscaUsuariosListaComPaginacaoCriteria(){
        return this.dao.buscaUsuariosListaComPaginacaoCriteria();
    }
}

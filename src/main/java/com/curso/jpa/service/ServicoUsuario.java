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
}

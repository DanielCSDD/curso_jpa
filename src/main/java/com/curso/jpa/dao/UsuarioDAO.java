package com.curso.jpa.dao;

import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.dto.UsuarioDTO;
import com.curso.jpa.model.Usuario;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UsuarioDAO extends GenericDAO<Usuario, Long> {

    /**
     * Consultando tabela: USUARIO retorna uma lista de usuários.
     */
    public List<Usuario> buscaListaUsuarios(){
        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class);
        return query.getResultList();
    }

    /**
     * Consultando tabela: USUARIO por parâmetro, onde utiliza-se uma consulta sem tipagem,
     * ou seja, o resultado da pesquisa será sem um tipo específico. Porém ao retornar deverá
     * realizar o CAST para o tipo desejado.
     */
    public Usuario buscaPorIdSemTipo(Integer id){
        String jpql = " FROM Usuario u WHERE u.id = :id";
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter("id", id);
        return (Usuario) query.getSingleResult();
    }

    /**
     * Consultando tabela: USUARIO por parâmetro
     */
    public Usuario buscaPorId(Integer id){
        String jpql = " FROM Usuario u WHERE u.id = :id";
        TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    /**
     * Consultando tabela: USUARIO por projeção utilizando Lista de objetos
     */
    public List<Object[]> buscaPorProjecao(){
        String jpql = " SELECT u.id, u.login, u.senha FROM Usuario u";
        TypedQuery<Object[]> query = getEntityManager().createQuery(jpql, Object[].class);
        return query.getResultList();
    }

    /**
     * Consultando tabela: USUARIO por projeção utilizando classe DTO
     */
    public List<UsuarioDTO> buscaPorProjecaoDTO(){
        String jpql = " SELECT new com.curso.jpa.dto.UsuarioDTO(u.id, u.login, u.senha) FROM Usuario u";
        TypedQuery<UsuarioDTO> query = getEntityManager().createQuery(jpql, UsuarioDTO.class);
        return query.getResultList();
    }

    /**
     * Consultando tabela: USUARIO retonando nomes
     */
    public List<String> buscaNomesUsuarios(){
        String jpqlNom = "select u.nome from Usuario u";
        TypedQuery<String> query = getEntityManager().createQuery(jpqlNom, String.class);
        return query.getResultList();
    }
}

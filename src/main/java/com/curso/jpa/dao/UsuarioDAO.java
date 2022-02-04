package com.curso.jpa.dao;

import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.dto.UsuarioDTO;
import com.curso.jpa.model.Usuario;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Stateless
public class UsuarioDAO extends GenericDAO<Usuario, Long> {

    private CriteriaBuilder criteriaBuilder;

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
        String jpql = "select u.nome from Usuario u";
        TypedQuery<String> query = getEntityManager().createQuery(jpql, String.class);
        return query.getResultList();
    }

    /**
     * Consultando tabela: USUARIO com join na tabela DOMINIO
     */
    public List<Usuario> buscaUsuariosComDominioJoin(){
        String jpql = "select u from Usuario u join u.dominio d where d.id = 1";
        TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class);
        return query.getResultList();
    }

    /**
     * Consultando tabela: USUARIO com left join na tabela COFIGURACAO
     */
    public List<Object[]> buscaUsuariosComConfiguracaoLeftJoin(){
        String jpql = "select u, c from Usuario u left join u.configuracao c";
        TypedQuery<Object[]> query = getEntityManager().createQuery(jpql, Object[].class);
        return query.getResultList();
    }

    /**
     * Consultando tabela: USUARIO com fetch join na tabela COFIGURACAO
     */
    public List<Usuario> buscaUsuariosComConfiguracaoFetchJoin(){
        String jpql = "select u from Usuario u join fetch u.configuracao join fetch u.dominio d";
        TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class);
        return query.getResultList();
    }

    /**
     * Consultando tabela: USUARIO com filtro
     */
    public List<Usuario> buscaUsuariosComFiltro(){
        // LIKE, IS NULL, IS EMPTY, BETWEEN, >, <, >=, <=, =, <>
        // LIKE = select u from Usuario u where u.nome like concat(:nomeUsuario, '%')
        // IS NULL = select u from Usuario u where u.senha is null
        // IS EMPTY = select d from Dominio d where d.usuarios is empty

        String jpql = "select u from Usuario u where u.ultimoAcesso between :ontem and :hoje";
        TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class)
                .setParameter("ontem", LocalDateTime.now().minusDays(1))
                .setParameter("hoje", LocalDateTime.now());
        return query.getResultList();
    }

    /**
     * Consultando tabela: USUARIO com filtro "baseado em operadores aritiméticos"
     */
    public List<Usuario> buscaUsuariosComFiltroOperadores(){
        String jpql = "select u from Usuario u where " +
                " (u.ultimoAcesso > :ontem and u.ultimoAcesso < :hoje) " +
                " or u.ultimoAcesso is null";
        TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class)
                .setParameter("ontem", LocalDateTime.now().minusDays(1))
                .setParameter("hoje", LocalDateTime.now());
        return query.getResultList();
    }

    /**
     * Consultando tabela: USUARIO com operador IN
     */
    public List<Usuario> buscaUsuariosComOperadorIn(){
        String jpql = "select u from Usuario u where u.id in (:ids)";
        TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class)
                .setParameter("ids", Arrays.asList(1,2));
        return query.getResultList();
    }

    /**
     * Consultando tabela: USUARIO ordenando resultado
     */
    public List<Usuario> buscaUsuariosListaOrdenada(){
        String jpql = "select u from Usuario u order by u.nome";
        TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class);
        return query.getResultList();
    }

    /**
     * Consultando tabela: USUARIO com paginação
     */
    public List<Usuario> buscaUsuariosListaComPaginacao(){
        String jpql = "select u from Usuario u";
        TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class)
                .setFirstResult(0)
                .setMaxResults(2);
        return query.getResultList();
    }

    /**
     * Consultando tabela: USUARIO com CriteriaQuery
     */
    public List<Usuario> buscaUsuariosListaComCriteriaQuery(){
        return listar();
    }

    /**
     * Consultando tabela: USUARIO retonando nomes utilizando CRITERIA
     */
    public List<String> buscaNomesUsuariosComCriteria(){
        this.criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<String> query = this.criteriaBuilder.createQuery(String.class);
        Root<Usuario> root = query.from(Usuario.class);
        query.select(root.get("nome"));
        TypedQuery<String> typedQuery = getEntityManager().createQuery(query);
        return typedQuery.getResultList();
    }

    /**
     * Consultando tabela: USUARIO por projeção utilizando Lista de objetos baseando-se em CRITERIA
     */
    public List<Object[]> buscaPorProjecaoCriteria(){
        this.criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Object[]> query = this.criteriaBuilder.createQuery(Object[].class);
        Root<Usuario> root = query.from(Usuario.class);
        query.multiselect(root.get("id"), root.get("login"), root.get("senha"));

        TypedQuery<Object[]> typedQuery = getEntityManager().createQuery(query);
        return typedQuery.getResultList();
    }

    /**
     * Consultando tabela: USUARIO por projeção utilizando classe DTO utilizando-se CRITERIA
     */
    public List<UsuarioDTO> buscaPorProjecaoDTOCriteria(){
        this.criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<UsuarioDTO> query = this.criteriaBuilder.createQuery(UsuarioDTO.class);
        Root<Usuario> root = query.from(Usuario.class);
        query.select(this.criteriaBuilder.construct(UsuarioDTO.class, root.get("id"), root.get("login"), root.get("nome")));
        TypedQuery<UsuarioDTO> typedQuery = getEntityManager().createQuery(query);
        return typedQuery.getResultList();
    }

    /**
     * Consultando tabela: USUARIO por parâmetro CRITERIA
     */
    public Usuario buscaPorIdCriteria(Integer id){
        this.criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> query = this.criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> root = query.from(Usuario.class);
        query.select(root);
        query.where(this.criteriaBuilder.equal(root.get("id"), id));
        TypedQuery<Usuario> typedQuery = getEntityManager().createQuery(query);
        return typedQuery.getSingleResult();
    }

    /**
     * Consultando tabela: USUARIO ordenando resultado CRITERIA
     */
    public List<Usuario> buscaUsuariosListaOrdenadaCriteria(){
        this.criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> query = this.criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> root = query.from(Usuario.class);
        query.select(root);
        query.orderBy(this.criteriaBuilder.asc(root.get("nome")));
        TypedQuery<Usuario> typedQuery = getEntityManager().createQuery(query);
        return typedQuery.getResultList();
    }

    /**
     * Consultando tabela: USUARIO com paginação CRITERIA
     */
    public List<Usuario> buscaUsuariosListaComPaginacaoCriteria(){
        this.criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> query = this.criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> root = query.from(Usuario.class);
        query.select(root);

        TypedQuery<Usuario> typedQuery = getEntityManager().createQuery(query)
                .setFirstResult(2)
                .setMaxResults(2);
        return typedQuery.getResultList();
    }
}

package com.curso.jpa.dao.generico;

import com.curso.jpa.exception.generico.AppException;
import com.curso.jpa.util.Propriedades;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public abstract class GenericDAO<T, ID extends Serializable> {

    @Resource
    private SessionContext ctxt;

    protected Class<T> persistentClass = null;

    private CriteriaBuilder criteriaBuilder;

    @PersistenceContext(unitName = GenericJTA.JTA)
    EntityManager em;

    protected EntityManager getEntityManager() {
        return this.em;
    }

    /**
     * Obtém classe do parametro estático que generaliza para generalização da classe
     */
    @SuppressWarnings("unchecked")
    protected GenericDAO() {

        if (getClass().getSuperclass().getGenericSuperclass() instanceof ParameterizedType) {
            this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass())
                    .getActualTypeArguments()[0];
        } else {
            // TODO:
            this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0];
        }
    }

    /**
     * Retorna a sessão do hibernate.
     */
    private Object getSession() {
        return getEntityManager().getDelegate();
    }


    /**
     * Conectando ao banco de dados diretamente pelo JNDI
     */
    protected Connection getConnection(String dataSourceName) throws AppException {
        try {
            DataSource data = (DataSource) ctxt.lookup(dataSourceName);
            return data.getConnection();
        } catch (Exception e) {
            throw new AppException(Propriedades.getMensagem("erro.conexao"));
        }
    }

    /**
     * Estabelece conexão direto com o banco de dados através do JNDI
     */
    protected Connection getConnection() throws AppException {
        return getConnection(Propriedades.getMensagem("MAIN_DATASOOURCE"));
    }

    /**
     * Gerencia a geração de chave primária das tabelas relacionados a determinado esquema.
     */
    public Long getNextSequence(String sequenceName) {
        String sql = "select srh." + sequenceName.toUpperCase() + ".nextval from dual";
        return ((BigDecimal) getEntityManager()
                .createNativeQuery(sql)
                .getSingleResult()).longValue();
    }

    /**
     * Listar generico utilizando critéria
     */
    public List<T> listar(){
            CriteriaQuery<T> consulta = getEntityManager().getCriteriaBuilder().createQuery(this.persistentClass);
            consulta.from(this.persistentClass);
            return getEntityManager().createQuery(consulta).getResultList();
    }
}

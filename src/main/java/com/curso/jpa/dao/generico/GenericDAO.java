package com.curso.jpa.dao.generico;

import com.curso.jpa.exception.generico.AppException;
import com.curso.jpa.util.Propriedades;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;

public abstract class GenericDAO<T, ID extends Serializable>{

    @Resource
    private SessionContext ctxt;

    protected Class<T> persistentClass = null;

    @PersistenceContext(unitName = GenericJTA.JTA)
    private EntityManager em;

    protected EntityManager getEntityManager(){
        return this.em;
    }

    /**
     * Obtém classe do parametro estático que generaliza para generalização da classe
     *
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
    private Object getSession(){
        return getEntityManager().getDelegate();
    }


    /**
     * Conectando ao banco de dados diretamente pelo JNDI
     */
    protected Connection getConnection(String dataSourceName) throws AppException {
        try {
            DataSource data = (DataSource) ctxt.lookup(dataSourceName);
            return data.getConnection();
        }catch (Exception e){
            throw new AppException(Propriedades.getMensagem("erro.conexao"));
        }
    }

    /**
     * Estabelece conexão direto com o banco de dados através do JNDI
     */
    protected Connection getConnection() throws AppException {
        return getConnection(Propriedades.getMensagem("MAIN_DATASOOURCE"));
    }
}

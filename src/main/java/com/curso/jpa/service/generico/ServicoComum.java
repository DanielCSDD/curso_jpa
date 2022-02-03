package com.curso.jpa.service.generico;

import com.curso.jpa.dao.generico.GenericDAO;

import java.io.Serializable;

/**
 * Classe que terá os métodos genéricos de: inserir, alterar, remover, listar...
 * @param <T>
 * @param <ID>
 */
public abstract class ServicoComum<T, ID extends Serializable> {

    public abstract GenericDAO<T, ID> getEntidadeDAO();

}

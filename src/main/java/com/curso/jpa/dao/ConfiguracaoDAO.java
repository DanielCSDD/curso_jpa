package com.curso.jpa.dao;

import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.model.Configuracao;

import javax.ejb.Stateless;

@Stateless
public class ConfiguracaoDAO extends GenericDAO<Configuracao, Long> {
}

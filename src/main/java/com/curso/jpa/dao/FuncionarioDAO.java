package com.curso.jpa.dao;

import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.model.Funcionario;
import com.curso.jpa.web.bean.auxiliar.Sessao;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;

@Stateless
public class FuncionarioDAO extends GenericDAO<Funcionario, Long> {

    private static final Logger log = Logger.getLogger(FuncionarioDAO.class);

    private static final Integer CALL_LIGHTMAN_ID = 1;

    /**
     * Simulação de abertura de sessão de usuario.
     */
    public Funcionario buscaFuncionario(){
        return getEntityManager().find(Funcionario.class, CALL_LIGHTMAN_ID);
    }

    /**
     * Simulação de atualização de cadastro de usuario.
     */
    public Funcionario atualizarDados(Sessao sessao){
        this.log.info("MENSAGEM_SUCESSO - " + sessao.getSessao() + ": Iniciando tentativa de atualaizar funcionário.");
        try {
            getEntityManager().merge(sessao.getFuncionario());

            this.log.info("MENSAGEM_SUCESSO - " + ": Funcionário foi atualizado. ");
            return sessao.getFuncionario();
        } catch (Exception e) {
            this.log.error("MENSAGEM_ERRO : Erro na atualização do funcionário. MSG: ", e);
        }
        return null;
    }

    /**
     * Simulação de verificação de atualização de cadastro de usuario.
     */
    public void verificaAtualizarDados(Sessao sessao){
        getEntityManager().clear();

        Funcionario funcionario = getEntityManager().find(Funcionario.class, sessao.getFuncionario().getId());

        this.log.info("MENSAGEM_SUCESSO - " + ": Tela da sessão " + sessao.getSessao() + " atualizada.");
        if (sessao.getEditarNome().equals(funcionario.getNome())) {
            this.log.info("MENSAGEM_SUCESSO - " + sessao.getSessao() + ": Bom... Foi atualizado certinho. " +
                    "Agora vou continuar meu trabalho.");
        } else {
            this.log.error("MENSAGEM_ERRO - " + sessao.getSessao() + ": Ueh! Não tinha deixado o nome " + funcionario.getNome() +
                    " eu tenho certeza que coloquei " + sessao.getEditarNome());
        }
    }
}

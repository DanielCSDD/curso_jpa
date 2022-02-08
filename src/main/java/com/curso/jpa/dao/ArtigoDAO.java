package com.curso.jpa.dao;

import com.curso.jpa.dao.generico.GenericDAO;
import com.curso.jpa.model.Artigo;
import org.apache.log4j.Logger;

import javax.ejb.*;
import javax.persistence.LockModeType;
import javax.transaction.*;

@Stateless
public class ArtigoDAO extends GenericDAO<Artigo, Long> {

    private static final Logger log = Logger.getLogger(ArtigoDAO.class);

    private static final Integer ID = 1;

    /**
     * Recupera do banco um objeto do tipo ARTIGO
     *
     * Utilizamos o conceito de Lock Pessimista:
     * LockModeType.PESSIMISTIC_WRITE: O gerenciador de entidade bloqueia a entidade assim que uma transação a atualiza.
     * Este modo de bloqueio força a serialização entre as transações que tentam atualizar os dados da entidade.
     * LockModeType.PESSIMISTIC_READ: O gerenciador de entidade bloqueia a entidade assim que uma transação a lê.
     * O bloqueio é mantido até que a transação seja concluída.
     * @return
     */
    public Artigo buscarArtigo() {
        log.info("Imediatamente antes find.");
        return getEntityManager().find(Artigo.class, ID, LockModeType.PESSIMISTIC_READ);
    }

    /**
     * Atualiza no banco um objeto do tipo ARTIGO
     */
    public Artigo alterar(Artigo artigo) {
        artigo.setConteudo("Alteração do " + artigo.getNomeEditor() + ".");
        getEntityManager().merge(artigo);
        return artigo;
    }

    /**
     * Atualiza no banco um objeto do tipo ARTIGO
     */
    public void javaEOBancoDados(Artigo artigo) {
        log.info("Imediatamente após find.");

        log(1, "Esperando 25 segundos...");
        esperar(25000);
        log(1, "Espera dos 25 segs terminada.");

        log(1, "Imediatamente antes do commit.");
        getEntityManager().persist(artigo);
        log(1, "Imediatamente após o commit.");
    }

    private static void log(Integer thread, String msg) {
        log.info("[THREAD_" + thread + "] " + msg);
    }

    private static void esperar(long milesegundos) {
        try {
            Thread.sleep(milesegundos);
        } catch (Exception e) {
        }
    }

    /**
     * Utiliza o conceito de transação quando um registro é manipulado ao mesmo tempo
     * por diversas conecções.
     * @param artigo
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void casoMaisPratico(Artigo artigo) {
        log.info("[THREAD_" + artigo.getNumThread() + "] Imediatamente após find.");
        log.info("[THREAD_" + artigo.getNumThread() + "] Esperando 3 segundos...");
        esperar(3000);
        log.info("[THREAD_" + artigo.getNumThread() + "] Espera dos 3 segs terminada.");

        log.info("[THREAD_" + artigo.getNumThread() + "] Imediatamente antes do commit.");
        getEntityManager().merge(artigo);
        log.info("[THREAD_" + artigo.getNumThread() + "] Imediatamente após o commit.");
    }
}

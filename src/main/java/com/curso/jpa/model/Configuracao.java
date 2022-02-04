package com.curso.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "srh", name = "configuracao")
@SequenceGenerator(name = "id_configuracao", sequenceName = "id_configuracao", allocationSize = 1)
public class Configuracao implements Serializable {

    @Id
    @GeneratedValue(generator = "id_configuracao", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_configuracao")
    private Integer id;

    @MapsId
    @OneToOne
    private Usuario usuario;

    @Column(name = "receber_notificacoes_configuracao")
    private boolean receberNotificacoes;

    @Column(name = "encerrar_sessao_automaticamente_configuracao")
    private boolean encerrarSessaoAutomaticamente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isReceberNotificacoes() {
        return receberNotificacoes;
    }

    public void setReceberNotificacoes(boolean receberNotificacoes) {
        this.receberNotificacoes = receberNotificacoes;
    }

    public boolean isEncerrarSessaoAutomaticamente() {
        return encerrarSessaoAutomaticamente;
    }

    public void setEncerrarSessaoAutomaticamente(boolean encerrarSessaoAutomaticamente) {
        this.encerrarSessaoAutomaticamente = encerrarSessaoAutomaticamente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Configuracao that = (Configuracao) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

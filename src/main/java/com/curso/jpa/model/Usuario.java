package com.curso.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(schema = "srh", name = "usuario")
@SequenceGenerator(name = "id_usuario", sequenceName = "id_usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(generator = "id_usuario", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "login_usuario")
    private String login;

    @Column(name = "senha_usuario")
    private String senha;

    @Column(name = "nome_usuario")
    private String nome;

    @Column(name = "ultimoAcesso_usuario")
    private LocalDateTime ultimoAcesso;

    @ManyToOne
    private Dominio dominio;

    @OneToOne(mappedBy = "usuario")
    private Configuracao configuracao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dominio getDominio() {
        return dominio;
    }

    public void setDominio(Dominio dominio) {
        this.dominio = dominio;
    }

//    public Configuracao getConfiguracao() {
//        return configuracao;
//    }
//
//    public void setConfiguracao(Configuracao configuracao) {
//        this.configuracao = configuracao;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

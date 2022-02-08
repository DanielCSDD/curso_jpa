package com.curso.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "srh", name = "artigo")
@SequenceGenerator(name = "id_artigo", sequenceName = "id_artigo", allocationSize = 1)
public class Artigo implements Serializable{

    @Id
    @GeneratedValue(generator = "id_artigo", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_artigo")
    private Integer id;

    @Column(name = "titulo_artigo")
    private String titulo;

    @Column(name = "conteudo_artigo")
    private String conteudo;

    @Transient
    private String nomeEditor;

    @Transient
    private Integer numThread;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getNomeEditor() {
        return nomeEditor;
    }

    public void setNomeEditor(String nomeEditor) {
        this.nomeEditor = nomeEditor;
    }

    public Integer getNumThread() {
        return numThread;
    }

    public void setNumThread(Integer numThread) {
        this.numThread = numThread;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artigo usuario = (Artigo) o;

        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

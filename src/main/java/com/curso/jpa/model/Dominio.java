package com.curso.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(schema = "srh", name = "dominio")
@SequenceGenerator(name = "id_dominio", sequenceName = "id_dominio", allocationSize = 1)
public class Dominio implements Serializable {

    @Id
    @GeneratedValue(generator = "id_dominio", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_dominio")
    private Integer id;

    @Column(name = "nome_dominio")
    private String nome;

    @OneToMany(mappedBy = "dominio")
    private List<Usuario> usuarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dominio dominio = (Dominio) o;

        return id.equals(dominio.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

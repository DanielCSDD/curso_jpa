package com.curso.jpa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "srh", name = "cliente")
@SequenceGenerator(name = "id_cliente", sequenceName = "id_cliente", allocationSize = 1)
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(generator = "id_cliente", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_cliente")
    private Integer id;

    @Column(name = "nome_cliente")
    private String nome;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
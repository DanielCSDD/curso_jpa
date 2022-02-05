package com.curso.jpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(schema = "srh", name = "funcionario")
@SequenceGenerator(name = "id_funcionario", sequenceName = "id_funcionario", allocationSize = 1)
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(generator = "id_funcionario", strategy = GenerationType.SEQUENCE)
    @Column(name = "id_funcionario")
    private Integer id;

    @Version
    @Column(name = "versao_funcionario")
    private Integer versao;

    @Column(name = "nome_funcionario")
    private String nome;

    @Column(name = "banco_horas_funcionario")
    private Integer bancoDeHoras;

    @Column(name = "salario_funcionario")
    private BigDecimal salario;

    @Column(name = "valor_hora_extra_funcionario")
    private BigDecimal valorHoraExtra;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getBancoDeHoras() {
        return bancoDeHoras;
    }

    public void setBancoDeHoras(Integer bancoDeHoras) {
        this.bancoDeHoras = bancoDeHoras;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getValorHoraExtra() {
        return valorHoraExtra;
    }

    public void setValorHoraExtra(BigDecimal valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Funcionario usuario = (Funcionario) o;

        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

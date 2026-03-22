package com.java.exercicios.models;


import jakarta.persistence.*;

@Entity(name = "Departamento")
@Table(name = "departamento")
public class DepartamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long id;

    @Column(name = "nome_departamento")
    private String nome;

    private String localização;

    public DepartamentoModel() {}

    public DepartamentoModel(Long id, String nome, String localização) {
        this.id = id;
        this.nome = nome;
        this.localização = localização;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalização() {
        return localização;
    }

    public void setLocalização(String localização) {
        this.localização = localização;
    }
}

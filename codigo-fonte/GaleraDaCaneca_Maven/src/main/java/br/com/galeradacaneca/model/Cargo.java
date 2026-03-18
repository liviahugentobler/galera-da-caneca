package br.com.galeradacaneca.model;

import javax.persistence.*;

@Entity
@Table(name = "cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private Integer idCargo;

    @Column(name = "descricao", nullable = false, unique = true, length = 15)
    private String descricao;

    public Cargo() {}

    public Cargo(String descricao) {
        this.descricao = descricao;
    }

    // Getters e Setters
    public Integer getIdCargo()              { return idCargo; }
    public void setIdCargo(Integer idCargo)  { this.idCargo = idCargo; }
    public String getDescricao()             { return descricao; }
    public void setDescricao(String d)       { this.descricao = d; }

    @Override
    public String toString() { return descricao; }
}

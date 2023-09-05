package com.alura.tech.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Eletrodomestico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String modelo;

    @Column
    private String potencia;

    @JsonIgnore
    @ManyToMany
    private List<Pessoa> pessoas = new ArrayList<>();

    @JsonIgnore
    @Column(updatable = false)
    private long dataCriacao;

    @PrePersist
    private void setDataCriacao() {
        this.dataCriacao = LocalTime.now(ZoneOffset.UTC).get(ChronoField.MILLI_OF_DAY);
    }

}

package com.alura.tech.entities;

import com.alura.tech.entities.enums.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Past
    @Column
    private LocalDate dataNascimento;

    @Column
    @Enumerated(EnumType.STRING)
    private Genero sexo;

    @OneToMany
    private List<Parentesco> parentesco = new ArrayList<>();

    @ManyToMany
    private List<Endereco> enderecos = new ArrayList<>();

    @ManyToMany
    private List<Eletrodomestico> eletrodomesticos = new ArrayList<>();

}

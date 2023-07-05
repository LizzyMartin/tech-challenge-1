package com.alura.tech.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Pessoa {
    public Pessoa() {
        this.id = UUID.randomUUID();
    }

    private UUID id;
    private String nome;
    private LocalDate dataNascimento;
    private Genero sexo;
    private String parentesco;

}

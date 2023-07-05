package com.alura.tech.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Eletrodomestico {

    public Eletrodomestico() {
        this.id = UUID.randomUUID();
    }

    private UUID id;
    private String nome;
    private String modelo;
    private String potencia;

}

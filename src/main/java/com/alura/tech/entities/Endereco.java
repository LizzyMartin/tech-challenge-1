package com.alura.tech.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Endereco {

    public Endereco () {
        this.id = UUID.randomUUID();
    }

    private UUID id;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

}

package com.alura.tech.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EletrodomesticoConsumoDTO {

    private Long id;
    private String nome;
    private String modelo;
    private String potencia;
    private long consumo;

}

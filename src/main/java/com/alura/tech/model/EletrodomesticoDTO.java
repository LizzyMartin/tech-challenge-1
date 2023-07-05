package com.alura.tech.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EletrodomesticoDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String modelo;

    @NotBlank
    private String potencia;

}

package com.alura.tech.model;

import com.alura.tech.entities.enums.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PessoaDTO {

    @NotBlank
    private String nome;

    @PastOrPresent
    private LocalDate dataNascimento;

    private Genero sexo;

}

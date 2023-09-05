package com.alura.tech.model;

import com.alura.tech.entities.enums.TipoParentesco;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
@AllArgsConstructor
public class ParentescoDTO {

    @NotBlank
    private TipoParentesco tipoParentesco;

    @NotBlank
    @NumberFormat
    private Long id;
}

package com.alura.tech.model.response;

import com.alura.tech.entities.Eletrodomestico;
import com.alura.tech.entities.Endereco;
import com.alura.tech.entities.enums.Genero;
import com.alura.tech.model.ParentescoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PessoaCompletoDTO {

    private String nome;
    private LocalDate dataNascimento;
    private Genero sexo;
    private List<ParentescoDTO> parentesco;
    private List<Endereco> enderecos;
    private List<Eletrodomestico> eletrodomesticos;

}

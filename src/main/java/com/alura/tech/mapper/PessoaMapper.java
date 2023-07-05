package com.alura.tech.mapper;

import com.alura.tech.entities.Pessoa;
import com.alura.tech.model.PessoaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    PessoaDTO pessoaToPessoaDTO(Pessoa pessoa);

    Pessoa pessoaDTOToPessoa(PessoaDTO pessoaDTO);
}

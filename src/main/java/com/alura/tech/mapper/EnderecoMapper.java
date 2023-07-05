package com.alura.tech.mapper;

import com.alura.tech.entities.Endereco;
import com.alura.tech.model.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    EnderecoDTO enderecoToEnderecoDTO(Endereco endereco);
    Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO);
}

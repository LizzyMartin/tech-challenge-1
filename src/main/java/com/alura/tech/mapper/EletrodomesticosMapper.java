package com.alura.tech.mapper;

import com.alura.tech.entities.Eletrodomestico;
import com.alura.tech.model.EletrodomesticoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EletrodomesticosMapper {

    EletrodomesticosMapper INSTANCE = Mappers.getMapper(EletrodomesticosMapper.class);

    EletrodomesticoDTO eletrodomesticoToEletrodomesticoDTO(Eletrodomestico eletrodomestico);

    Eletrodomestico eletrodomesticoDTOToEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO);
}

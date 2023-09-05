package com.alura.tech.mapper;

import com.alura.tech.entities.Eletrodomestico;
import com.alura.tech.model.EletrodomesticoDTO;
import com.alura.tech.model.response.EletrodomesticoConsumoDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.lang.NonNull;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EletrodomesticosMapper {

    EletrodomesticosMapper INSTANCE = Mappers.getMapper(EletrodomesticosMapper.class);

    EletrodomesticoDTO eletrodomesticoToEletrodomesticoDTO(Eletrodomestico eletrodomestico);

    @Mapping(target = "consumo", ignore = true)
    EletrodomesticoConsumoDTO eletrodomesticoToEletrodomesticoConsumoDTO(Eletrodomestico eletrodomestico);

    Eletrodomestico eletrodomesticoDTOToEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO);

    @AfterMapping
    default void calculaTempoConsumo(@NonNull Eletrodomestico eletrodomestico, @NonNull @MappingTarget EletrodomesticoConsumoDTO eletrodomesticoConsumoDTO) {
        long now = LocalTime.now(ZoneOffset.UTC).get(ChronoField.MILLI_OF_DAY);
        eletrodomesticoConsumoDTO.setConsumo(now - eletrodomestico.getDataCriacao());
    }
}

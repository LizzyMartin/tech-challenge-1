package com.alura.tech.service;

import com.alura.tech.entities.Eletrodomestico;
import com.alura.tech.model.EletrodomesticoDTO;
import com.alura.tech.model.response.EletrodomesticoConsumoDTO;

import java.util.List;

public interface EletrodomesticoService {
    EletrodomesticoConsumoDTO listaEletrodomestico(Long id);

    List<EletrodomesticoConsumoDTO> listaEletrodomesticos();

    Eletrodomestico listaEletrodomesticoSemConsumo(Long id);

    List<EletrodomesticoConsumoDTO> buscaEletrodomesticos(EletrodomesticoDTO eletrodomesticoDTO);

    void adicionaEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO);

    void atualizaEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO, Long id);

    void deletaEletrodomestico(Long id);
}

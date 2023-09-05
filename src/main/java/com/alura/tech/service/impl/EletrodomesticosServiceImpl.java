package com.alura.tech.service.impl;

import com.alura.tech.entities.Eletrodomestico;
import com.alura.tech.mapper.EletrodomesticosMapper;
import com.alura.tech.model.EletrodomesticoDTO;
import com.alura.tech.model.response.EletrodomesticoConsumoDTO;
import com.alura.tech.repository.EletrodomesticosRepository;
import com.alura.tech.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EletrodomesticosServiceImpl implements EletrodomesticoService {

    private final EletrodomesticosRepository repository;
    private final EletrodomesticosMapper mapper;

    @Autowired
    private EletrodomesticosServiceImpl(EletrodomesticosRepository repository, EletrodomesticosMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EletrodomesticoConsumoDTO> listaEletrodomesticos() {
        return this.repository.findAll().stream()
                .map(mapper::eletrodomesticoToEletrodomesticoConsumoDTO)
                .collect(Collectors.toList());
    }

    public List<EletrodomesticoConsumoDTO> buscaEletrodomesticos(EletrodomesticoDTO eletrodomesticoDTO) {
        if (eletrodomesticoDTO == null)
            return this.listaEletrodomesticos();
        if (eletrodomesticoDTO.getNome() != null)
            return this.repository.findAllByNome(eletrodomesticoDTO.getNome()).stream().map(mapper::eletrodomesticoToEletrodomesticoConsumoDTO)
                    .collect(Collectors.toList());
        if (eletrodomesticoDTO.getPotencia() != null)
            return this.repository.findAllByPotencia(eletrodomesticoDTO.getPotencia()).stream().map(mapper::eletrodomesticoToEletrodomesticoConsumoDTO)
                    .collect(Collectors.toList());
        if (eletrodomesticoDTO.getModelo() != null)
            return this.repository.findAllByModelo(eletrodomesticoDTO.getModelo()).stream().map(mapper::eletrodomesticoToEletrodomesticoConsumoDTO)
                    .collect(Collectors.toList());
        return new ArrayList<>();
    }

    public EletrodomesticoConsumoDTO listaEletrodomestico(Long id) {
        var eletrodometico = this.repository.findById(id);
        return eletrodometico.map(mapper::eletrodomesticoToEletrodomesticoConsumoDTO).orElse(null);
    }

    public Eletrodomestico listaEletrodomesticoSemConsumo(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public void adicionaEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO) {
        this.repository.save(mapper.eletrodomesticoDTOToEletrodomestico(eletrodomesticoDTO));
    }

    public void atualizaEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO, Long id) {
        if (this.repository.findById(id).isEmpty())
            return;
        this.repository.findById(id).ifPresent(eletrodomestico -> {
            eletrodomestico.setNome(eletrodomesticoDTO.getNome());
            eletrodomestico.setModelo(eletrodomesticoDTO.getModelo());
            eletrodomestico.setPotencia(eletrodomesticoDTO.getPotencia());
        });
    }

    public void deletaEletrodomestico(Long id) {
        this.repository.deleteById(id);
    }

}

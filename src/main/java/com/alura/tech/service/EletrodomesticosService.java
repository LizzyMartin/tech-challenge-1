package com.alura.tech.service;

import com.alura.tech.entities.Eletrodomestico;
import com.alura.tech.exceptions.InvalidHomeApplianceException;
import com.alura.tech.model.EletrodomesticoDTO;
import com.alura.tech.repository.EletrodomesticosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EletrodomesticosService {

    @Autowired
    private EletrodomesticosRepository repository;

    public List<Eletrodomestico> listaEletrodomesticos() {
        return this.repository.listaEletrodomesticos();
    }

    public Eletrodomestico listaEletrodomestico(UUID id) {
        return this.repository.listaEletrodomestico(id);
    }

    public void adicionaEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO) {
        this.repository.adicionaEletrodomestico(eletrodomesticoDTO);
    }

    public void atualizaEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO, UUID id) throws InvalidHomeApplianceException {
        this.repository.atualizaEletrodomestico(eletrodomesticoDTO, id);
    }

    public void deletaEletrodomestico(UUID id) throws InvalidHomeApplianceException {
        this.repository.deletaEletrodomestico(id);
    }

}

package com.alura.tech.repository;

import com.alura.tech.entities.Eletrodomestico;
import com.alura.tech.exceptions.InvalidHomeApplianceException;
import com.alura.tech.mapper.EletrodomesticosMapper;
import com.alura.tech.model.EletrodomesticoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class EletrodomesticosRepository {

    @Autowired
    private EletrodomesticosMapper mapper;

    private final List<Eletrodomestico> eletrodomesticos = new ArrayList<>();

    public List<Eletrodomestico> listaEletrodomesticos() {
        return this.eletrodomesticos;
    }

    public Eletrodomestico listaEletrodomestico(UUID id) {
        return eletrodomesticos.stream()
                .filter(endereco -> endereco.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public void adicionaEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO) {
        this.eletrodomesticos.add(mapper.eletrodomesticoDTOToEletrodomestico(eletrodomesticoDTO));
    }

    public void atualizaEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO, UUID id) throws InvalidHomeApplianceException {
        boolean founded = false;
        for (Eletrodomestico eletrodomestico : this.eletrodomesticos) {
            if (eletrodomestico.getId().equals(id)) {
                eletrodomestico.setNome(eletrodomesticoDTO.getNome());
                eletrodomestico.setModelo(eletrodomesticoDTO.getModelo());
                eletrodomestico.setPotencia(eletrodomesticoDTO.getPotencia());
                founded = true;
                break;
            }
        }

        if (!founded)
            throw new InvalidHomeApplianceException();
    }

    public void deletaEletrodomestico(UUID id) throws InvalidHomeApplianceException {
        boolean founded = false;
        for (Eletrodomestico eletrodomestico : this.eletrodomesticos) {
            if (eletrodomestico.getId().equals(id)) {
                this.eletrodomesticos.remove(eletrodomestico);
                founded = true;
                break;
            }
        }

        if (!founded)
            throw new InvalidHomeApplianceException();
    }

}

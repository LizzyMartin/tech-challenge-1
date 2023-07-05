package com.alura.tech.controller;

import com.alura.tech.controller.interfaces.EletrodomesticosRest;
import com.alura.tech.entities.Eletrodomestico;
import com.alura.tech.exceptions.InvalidHomeApplianceException;
import com.alura.tech.model.EletrodomesticoDTO;
import com.alura.tech.service.EletrodomesticosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
public class EletrodomesticosController implements EletrodomesticosRest {

    @Autowired
    private EletrodomesticosService service;

    @Override
    public ResponseEntity<?> listaEletrodomesticos() {
        List<Eletrodomestico> eletrodomesticos = this.service.listaEletrodomesticos();
        return ResponseEntity.ok().body(eletrodomesticos);
    }

    @Override
    public ResponseEntity<?> listaEletrodomestico(UUID id) {
        Eletrodomestico eletrodomestico = this.service.listaEletrodomestico(id);
        return ResponseEntity.ok().body(Objects.requireNonNullElse(eletrodomestico, "Eletrodomestico não encontrado"));
    }

    @Override
    public ResponseEntity<?> cadastraEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO) {
        this.service.adicionaEletrodomestico(eletrodomesticoDTO);
        return new ResponseEntity<>("Eletrodomestico cadastrado!", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> atualizaEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO, UUID id) {
        try {
            this.service.atualizaEletrodomestico(eletrodomesticoDTO, id);
            return ResponseEntity.ok().body("Eletrodomestico atualizado com sucesso!");
        } catch (InvalidHomeApplianceException e) {
            return ResponseEntity.ok().body("Eletrodomestico não encontrado!");
        }
    }

    @Override
    public ResponseEntity<?> deletaEletrodomestico(UUID id) {
        try {
            this.service.deletaEletrodomestico(id);
            return new ResponseEntity<>("Eletrodomestico deletado com sucesso!", HttpStatus.NO_CONTENT);
        } catch (InvalidHomeApplianceException e) {
            return ResponseEntity.ok().body("Eletrodomestico não encontrado!");
        }
    }
}

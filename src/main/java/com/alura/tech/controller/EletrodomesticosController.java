package com.alura.tech.controller;

import com.alura.tech.controller.interfaces.EletrodomesticosRest;
import com.alura.tech.model.EletrodomesticoDTO;
import com.alura.tech.model.response.EletrodomesticoConsumoDTO;
import com.alura.tech.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EletrodomesticosController implements EletrodomesticosRest {

    private final EletrodomesticoService service;

    @Autowired
    private EletrodomesticosController(EletrodomesticoService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<EletrodomesticoConsumoDTO>> listaEletrodomesticos() {
        var eletrodomesticos = this.service.listaEletrodomesticos();
        return ResponseEntity.ok().body(eletrodomesticos);
    }

    @Override
    public ResponseEntity<EletrodomesticoConsumoDTO> listaEletrodomestico(Long id) {
        var eletrodomestico = this.service.listaEletrodomestico(id);
        if (eletrodomestico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(eletrodomestico);
    }

    @Override
    public ResponseEntity<List<EletrodomesticoConsumoDTO>> buscaEletrodomesticos(EletrodomesticoDTO eletrodomesticoDTO) {
        var eletrodomestico = this.service.buscaEletrodomesticos(eletrodomesticoDTO);
        return ResponseEntity.ok().body(eletrodomestico);
    }

    @Override
    public ResponseEntity<?> cadastraEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO) {
        this.service.adicionaEletrodomestico(eletrodomesticoDTO);
        return new ResponseEntity<>("Eletrodomestico cadastrado!", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> atualizaEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO, Long id) {
        try {
            this.service.atualizaEletrodomestico(eletrodomesticoDTO, id);
            return ResponseEntity.ok().body("Eletrodomestico atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.ok().body("Eletrodomestico não encontrado!");
        }
    }

    @Override
    public ResponseEntity<?> deletaEletrodomestico(Long id) {
        try {
            this.service.deletaEletrodomestico(id);
            return new ResponseEntity<>("Eletrodomestico deletado com sucesso!", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.ok().body("Eletrodomestico não encontrado!");
        }
    }
}

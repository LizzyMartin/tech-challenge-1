package com.alura.tech.controller;

import com.alura.tech.controller.interfaces.EnderecoRest;
import com.alura.tech.entities.Endereco;
import com.alura.tech.exceptions.InvalidAddressException;
import com.alura.tech.model.EnderecoDTO;
import com.alura.tech.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
public class EnderecoController implements EnderecoRest {

    @Autowired
    private EnderecoService service;

    @Override
    public ResponseEntity<?> listaEnderecos() {
        List<Endereco> enderecos = this.service.listaEnderecos();
        return ResponseEntity.ok().body(enderecos);
    }

    @Override
    public ResponseEntity<?> listaEndereco(UUID id) {
        Endereco endereco = this.service.listaEndereco(id);
        return ResponseEntity.ok().body(Objects.requireNonNullElse(endereco, "Endereço não encontrado"));
    }

    @Override
    public ResponseEntity<?> cadastraEndereco(EnderecoDTO endereco) {
        this.service.adicionaEndereco(endereco);
        return new ResponseEntity<>("Endereco cadastrado!", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> atualizaEndereco(EnderecoDTO enderecoDTO, UUID id) {
        try {
            this.service.atualizaEndereco(enderecoDTO, id);
            return ResponseEntity.ok().body("Endereço atualizado com sucesso!");
        } catch (InvalidAddressException e) {
            return ResponseEntity.ok().body("Endereço não encontrado!");
        }
    }

    @Override
    public ResponseEntity<?> deletaEndereco(UUID id) {
        try {
            this.service.deletaEndereco(id);
            return new ResponseEntity<>("Endereço deletado com sucesso!", HttpStatus.NO_CONTENT);
        } catch (InvalidAddressException e) {
            return ResponseEntity.ok().body("Endereço não encontrado!");
        }
    }
}

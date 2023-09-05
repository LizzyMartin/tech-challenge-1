package com.alura.tech.controller;

import com.alura.tech.controller.interfaces.EnderecoRest;
import com.alura.tech.entities.Endereco;
import com.alura.tech.model.EnderecoDTO;
import com.alura.tech.service.impl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class EnderecoController implements EnderecoRest {

    @Autowired
    private EnderecoServiceImpl service;

    @Override
    public ResponseEntity<?> listaEnderecos() {
        List<Endereco> enderecos = this.service.listaEnderecos();
        return ResponseEntity.ok().body(enderecos);
    }

    @Override
    public ResponseEntity<?> listaEndereco(Long id) {
        Endereco endereco = this.service.listaEndereco(id);
        return ResponseEntity.ok().body(Objects.requireNonNullElse(endereco, "Endereço não encontrado"));
    }

    @Override
    public ResponseEntity<?> cadastraEndereco(EnderecoDTO endereco) {
        this.service.adicionaEndereco(endereco);
        return new ResponseEntity<>("Endereco cadastrado!", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Endereco>> buscaEnderecos(EnderecoDTO endereco) {
        var enderecos = this.service.buscaEnderecos(endereco);
        return ResponseEntity.ok().body(enderecos);
    }

    @Override
    public ResponseEntity<?> atualizaEndereco(EnderecoDTO enderecoDTO, Long id) {
        try {
            this.service.atualizaEndereco(enderecoDTO, id);
            return ResponseEntity.ok().body("Endereço atualizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.ok().body("Endereço não encontrado!");
        }
    }

    @Override
    public ResponseEntity<String> deletaEndereco(Long id) {
        try {
            this.service.deletaEndereco(id);
            return new ResponseEntity<>("Endereço deletado com sucesso!", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.ok().body("Endereço não encontrado!");
        }
    }
}

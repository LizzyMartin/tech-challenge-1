package com.alura.tech.controller;

import com.alura.tech.controller.interfaces.PessoaRest;
import com.alura.tech.entities.enums.TipoParentesco;
import com.alura.tech.exceptions.AssociationException;
import com.alura.tech.model.PessoaDTO;
import com.alura.tech.model.response.PessoaCompletoDTO;
import com.alura.tech.service.PessoaService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PessoaController implements PessoaRest {

    private final PessoaService service;

    @Autowired
    private PessoaController(PessoaService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<PessoaCompletoDTO>> listaPessoas() {
        var pessoas = this.service.listaPessoas();
        return ResponseEntity.ok().body(pessoas);
    }

    @Override
    public ResponseEntity<List<PessoaCompletoDTO>> buscaPessoas(PessoaDTO pessoaDTO) {
        var pessoa = this.service.buscaPessoas(pessoaDTO);
        return ResponseEntity.ok().body(pessoa);
    }

    @Override
    public ResponseEntity<PessoaCompletoDTO> listaPessoa(Long id) {
        try {
            var pessoa = this.service.listPessoaCompleto(id);
            return ResponseEntity.ok().body(pessoa);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> cadastraPessoa(PessoaDTO pessoaDTO) {
        var genero = pessoaDTO.getSexo();
        if (genero == null)
            return new ResponseEntity<>("O sexo não pode estar nulo!", HttpStatus.BAD_REQUEST);
        try {
            this.service.cadastraPessoa(pessoaDTO);
            return new ResponseEntity<>("Pessoa cadastrada!", HttpStatus.CREATED);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Payload inválido! Violações: " + e.getConstraintViolations(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> atualizaPessoa(PessoaDTO pessoaDTO, Long id) {
        try {
            this.service.atualizaPessoa(pessoaDTO, id);
            return ResponseEntity.ok().body("Pessoa atualizada com sucesso!");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> deletaPessoa(Long id) {
        try {
            this.service.deletaPessoa(id);
            return new ResponseEntity<>("Pessoa deletada com sucesso!", HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> associaPessoaEletrodomestico(Long pessoaId, Long eletrodomesticoId) {
        try {
            this.service.associaPessoaEletrodomestico(pessoaId, eletrodomesticoId);
            return ResponseEntity.noContent().build();
        } catch (AssociationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Void> associaPessoaEndereco(Long pessoaId, Long enderecoId) {
        try {
            this.service.associaPessoaEndereco(pessoaId, enderecoId);
            return ResponseEntity.noContent().build();
        } catch (AssociationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Void> associaPessoaParente(Long pessoaId, Long parenteId, TipoParentesco tipoParentesco) {
        try {
            this.service.associaPessoaParente(pessoaId, parenteId, tipoParentesco);
            return ResponseEntity.noContent().build();
        } catch (AssociationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

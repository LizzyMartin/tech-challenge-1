package com.alura.tech.controller;

import com.alura.tech.controller.interfaces.PessoaRest;
import com.alura.tech.entities.Genero;
import com.alura.tech.entities.Pessoa;
import com.alura.tech.exceptions.InvalidPersonException;
import com.alura.tech.model.PessoaDTO;
import com.alura.tech.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
public class PessoaController implements PessoaRest {

    @Autowired
    private PessoaService service;

    @Override
    public ResponseEntity<?> listaPessoas() {
        List<Pessoa> pessoas = this.service.listaPessoas();
        return ResponseEntity.ok().body(pessoas);
    }

    @Override
    public ResponseEntity<?> listaPessoa(UUID id) {
        Pessoa pessoa = this.service.listaPessoa(id);
        return ResponseEntity.ok().body(Objects.requireNonNullElse(pessoa, "Pessoa não encontrada"));
    }

    @Override
    public ResponseEntity<?> cadastraPessoa(PessoaDTO pessoaDTO) {
        Genero genero = pessoaDTO.getSexo();
        if (genero == null)
            return new ResponseEntity<>("O sexo não pode estar nulo!", HttpStatus.BAD_REQUEST);
        this.service.cadastraPessoa(pessoaDTO);
        return new ResponseEntity<>("Pessoa cadastrada!", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> atualizaPessoa(PessoaDTO pessoaDTO, UUID id) {
        try {
            this.service.atualizaPessoa(pessoaDTO, id);
            return ResponseEntity.ok().body("Pessoa atualizada com sucesso!");
        } catch (InvalidPersonException e) {
            return ResponseEntity.ok().body("Pessoa não encontrada!");
        }
    }

    @Override
    public ResponseEntity<?> deletaPessoa(UUID id) {
        try {
            this.service.deletaPessoa(id);
            return new ResponseEntity<>("Pessoa deletada com sucesso!", HttpStatus.NO_CONTENT);
        } catch (InvalidPersonException e) {
            return ResponseEntity.ok().body("Pessoa não encontrada!");
        }
    }
}

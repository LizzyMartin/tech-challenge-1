package com.alura.tech.service;

import com.alura.tech.entities.Pessoa;
import com.alura.tech.exceptions.InvalidPersonException;
import com.alura.tech.model.PessoaDTO;
import com.alura.tech.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> listaPessoas() {
        return this.repository.listaPessoas();
    }

    public Pessoa listaPessoa(UUID id) {
        return this.repository.listaPessoa(id);
    }

    public void cadastraPessoa(PessoaDTO pessoaDTO) {
        this.repository.adicionaPessoa(pessoaDTO);
    }

    public void atualizaPessoa(PessoaDTO pessoaDTO, UUID id) throws InvalidPersonException {
        this.repository.atualizaPessoa(pessoaDTO, id);
    }

    public void deletaPessoa(UUID id) throws InvalidPersonException {
        this.repository.deletaPessoa(id);
    }

}

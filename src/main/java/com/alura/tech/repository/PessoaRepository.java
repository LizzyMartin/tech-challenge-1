package com.alura.tech.repository;

import com.alura.tech.entities.Pessoa;
import com.alura.tech.exceptions.InvalidPersonException;
import com.alura.tech.mapper.PessoaMapper;
import com.alura.tech.model.PessoaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PessoaRepository {

    @Autowired
    private PessoaMapper mapper;

    private final List<Pessoa> pessoas = new ArrayList<>();

    public List<Pessoa> listaPessoas() {
        return this.pessoas;
    }

    public Pessoa listaPessoa(UUID id) {
        return pessoas.stream()
                .filter(pessoa -> pessoa.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public void adicionaPessoa(PessoaDTO pessoaDTO) {
        this.pessoas.add(mapper.pessoaDTOToPessoa(pessoaDTO));
    }

    public void atualizaPessoa(PessoaDTO pessoaDTO, UUID id) throws InvalidPersonException {
        boolean founded = false;
        for (Pessoa pessoa : this.pessoas) {
            if (pessoa.getId().equals(id)) {
                pessoa.setNome(pessoaDTO.getNome());
                pessoa.setSexo(pessoaDTO.getSexo());
                pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
                pessoa.setParentesco(pessoaDTO.getParentesco());
                founded = true;
                break;
            }
        }

        if (!founded)
            throw new InvalidPersonException();
    }

    public void deletaPessoa(UUID id) throws InvalidPersonException {
        boolean founded = false;
        for (Pessoa pessoa : this.pessoas) {
            if (pessoa.getId().equals(id)) {
                this.pessoas.remove(pessoa);
                founded = true;
                break;
            }
        }

        if (!founded)
            throw new InvalidPersonException();
    }

}

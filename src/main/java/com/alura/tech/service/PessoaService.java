package com.alura.tech.service;

import com.alura.tech.entities.Pessoa;
import com.alura.tech.entities.enums.TipoParentesco;
import com.alura.tech.exceptions.AssociationException;
import com.alura.tech.model.PessoaDTO;
import com.alura.tech.model.response.PessoaCompletoDTO;

import java.util.List;
import java.util.NoSuchElementException;

public interface PessoaService {

    List<PessoaCompletoDTO> listaPessoas();

    List<PessoaCompletoDTO> buscaPessoas(PessoaDTO pessoaDTO);

    Pessoa listaPessoa(Long id) throws IllegalArgumentException, NoSuchElementException;

    PessoaCompletoDTO listPessoaCompleto(Long id);

    void cadastraPessoa(PessoaDTO pessoaDTO);

    void atualizaPessoa(PessoaDTO pessoaDTO, Long id) throws NoSuchElementException;

    void deletaPessoa(Long id) throws IllegalArgumentException;

    void associaPessoaEndereco(Long pessoaId, Long enderecoId) throws AssociationException;

    void associaPessoaEletrodomestico(Long pessoaId, Long eletrodomesticoId) throws AssociationException;

    void associaPessoaParente(Long pessoaId, Long parenteId, TipoParentesco tipoParentesco) throws AssociationException;
}

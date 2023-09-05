package com.alura.tech.service;

import com.alura.tech.entities.Endereco;
import com.alura.tech.model.EnderecoDTO;

import java.util.List;

public interface EnderecoService {

    List<Endereco> listaEnderecos();

    Endereco listaEndereco(Long id);

    List<Endereco> buscaEnderecos(EnderecoDTO enderecoDTO);

    void adicionaEndereco(EnderecoDTO endereco);

    void atualizaEndereco(EnderecoDTO enderecoDTO, Long id);

    void deletaEndereco(Long id);
}

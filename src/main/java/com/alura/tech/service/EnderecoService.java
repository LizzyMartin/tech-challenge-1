package com.alura.tech.service;

import com.alura.tech.entities.Endereco;
import com.alura.tech.exceptions.InvalidAddressException;
import com.alura.tech.model.EnderecoDTO;
import com.alura.tech.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> listaEnderecos() {
        return this.repository.listaEnderecos();
    }

    public Endereco listaEndereco(UUID id) {
        return this.repository.listaEndereco(id);
    }

    public void adicionaEndereco(EnderecoDTO endereco) {
        this.repository.adicionaEndereco(endereco);
    }

    public void atualizaEndereco(EnderecoDTO enderecoDTO, UUID id) throws InvalidAddressException {
        this.repository.atualizaEndereco(enderecoDTO, id);
    }

    public void deletaEndereco(UUID id) throws InvalidAddressException {
        this.repository.deletaEndereco(id);
    }

}

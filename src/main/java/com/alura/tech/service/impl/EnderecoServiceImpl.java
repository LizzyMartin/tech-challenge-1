package com.alura.tech.service.impl;

import com.alura.tech.entities.Endereco;
import com.alura.tech.mapper.EnderecoMapper;
import com.alura.tech.model.EnderecoDTO;
import com.alura.tech.repository.EnderecoRepository;
import com.alura.tech.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository repository;
    private final EnderecoMapper mapper;

    @Autowired
    private EnderecoServiceImpl(EnderecoRepository repository, EnderecoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Endereco> listaEnderecos() {
        return this.repository.findAll();
    }

    public List<Endereco> buscaEnderecos(EnderecoDTO enderecoDTO) {
        if (enderecoDTO == null)
            return this.listaEnderecos();
        if (enderecoDTO.getRua() != null)
            return this.repository.findAllByRua(enderecoDTO.getRua());
        if (enderecoDTO.getBairro() != null)
            return this.repository.findAllByBairro(enderecoDTO.getBairro());
        if (enderecoDTO.getCidade() != null)
            return this.repository.findAllByCidade(enderecoDTO.getCidade());
        if (enderecoDTO.getEstado() != null)
            return this.repository.findAllByEstado(enderecoDTO.getEstado());
        return new ArrayList<>();
    }

    public Endereco listaEndereco(Long id) {
        var endereco = this.repository.findById(id);
        return endereco.orElse(null);
    }

    public void adicionaEndereco(EnderecoDTO enderecoDTO) {
        this.repository.save(mapper.enderecoDTOToEndereco(enderecoDTO));
    }

    public void atualizaEndereco(EnderecoDTO enderecoDTO, Long id) {
        if (this.repository.findById(id).isEmpty())
            return;
        this.repository.findById(id).ifPresent(endereco -> {
            endereco.setRua(enderecoDTO.getRua());
            endereco.setBairro(enderecoDTO.getBairro());
            endereco.setNumero(enderecoDTO.getNumero());
            endereco.setEstado(enderecoDTO.getEstado());
            endereco.setCidade(endereco.getCidade());
        });
    }

    public void deletaEndereco(Long id) {
        this.repository.deleteById(id);
    }

}

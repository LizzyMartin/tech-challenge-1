package com.alura.tech.repository;

import com.alura.tech.entities.Endereco;
import com.alura.tech.exceptions.InvalidAddressException;
import com.alura.tech.mapper.EnderecoMapper;
import com.alura.tech.model.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class EnderecoRepository {

    @Autowired
    private EnderecoMapper mapper;

    private final List<Endereco> enderecos = new ArrayList<>();

    public List<Endereco> listaEnderecos() {
        return this.enderecos;
    }

    public Endereco listaEndereco(UUID id) {
        return enderecos.stream()
                .filter(endereco -> endereco.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public void adicionaEndereco(EnderecoDTO enderecoDTO) {
        this.enderecos.add(mapper.enderecoDTOToEndereco(enderecoDTO));
    }

    public void atualizaEndereco(EnderecoDTO enderecoDTO, UUID id) throws InvalidAddressException {
        boolean founded = false;
        for (Endereco endereco : this.enderecos) {
            if (endereco.getId().equals(id)) {
                endereco.setRua(enderecoDTO.getRua());
                endereco.setNumero(enderecoDTO.getNumero());
                endereco.setBairro(enderecoDTO.getBairro());
                endereco.setCidade(enderecoDTO.getCidade());
                endereco.setEstado(enderecoDTO.getEstado());
                founded = true;
                break ;
            }
        }

        if (!founded)
            throw new InvalidAddressException();
    }

    public void deletaEndereco(UUID id) throws InvalidAddressException {
        boolean founded = false;
        for (Endereco endereco : this.enderecos) {
            if (endereco.getId().equals(id)) {
                this.enderecos.remove(endereco);
                founded = true;
                break;
            }
        }

        if (!founded)
            throw new InvalidAddressException();
    }
}

package com.alura.tech.service.impl;

import com.alura.tech.entities.Parentesco;
import com.alura.tech.entities.Pessoa;
import com.alura.tech.entities.enums.TipoParentesco;
import com.alura.tech.exceptions.AssociationException;
import com.alura.tech.mapper.PessoaMapper;
import com.alura.tech.model.PessoaDTO;
import com.alura.tech.model.response.PessoaCompletoDTO;
import com.alura.tech.repository.ParentescoRepository;
import com.alura.tech.repository.PessoaRepository;
import com.alura.tech.service.EletrodomesticoService;
import com.alura.tech.service.EnderecoService;
import com.alura.tech.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository repository;
    private final ParentescoRepository parentescoRepository;
    private final PessoaMapper mapper;
    private final EnderecoService enderecoService;
    private final EletrodomesticoService eletrodomesticoService;

    @Autowired
    private PessoaServiceImpl(PessoaRepository repository, PessoaMapper mapper,
                              EnderecoService enderecoService, EletrodomesticoService eletrodomesticoService,
                              ParentescoRepository parentescoRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.enderecoService = enderecoService;
        this.eletrodomesticoService = eletrodomesticoService;
        this.parentescoRepository = parentescoRepository;
    }

    public List<PessoaCompletoDTO> listaPessoas() {
        return this.repository.findAll().stream().map(mapper::pessoaToPessoaCompletoDTO).collect(Collectors.toList());
    }

    public List<PessoaCompletoDTO> buscaPessoas(PessoaDTO pessoaDTO) {
        if (pessoaDTO == null)
            return this.listaPessoas();
        if (pessoaDTO.getNome() != null)
            return this.repository.findAllByNome(pessoaDTO.getNome()).stream().map(mapper::pessoaToPessoaCompletoDTO).collect(Collectors.toList());
        if (pessoaDTO.getSexo() != null)
            return this.repository.findAllBySexo(pessoaDTO.getSexo()).stream().map(mapper::pessoaToPessoaCompletoDTO).collect(Collectors.toList());
        return new ArrayList<>();
    }

    public Pessoa listaPessoa(Long id) throws IllegalArgumentException, NoSuchElementException {
        return this.repository.findById(id).orElseThrow();
    }

    public PessoaCompletoDTO listPessoaCompleto(Long id) {
        try {
            var pessoa = this.listaPessoa(id);
            return mapper.pessoaToPessoaCompletoDTO(pessoa);
        } catch (Exception e) {
            return null;
        }
    }

    public void cadastraPessoa(PessoaDTO pessoaDTO) {
        this.repository.save(mapper.pessoaDTOToPessoa(pessoaDTO));
    }

    public void atualizaPessoa(PessoaDTO pessoaDTO, Long id) throws NoSuchElementException {
        if (this.repository.findById(id).isEmpty())
            throw new NoSuchElementException();
        this.repository.findById(id).ifPresent(pessoa -> {
            pessoa.setNome(pessoaDTO.getNome());
            pessoa.setSexo(pessoaDTO.getSexo());
            pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
            pessoa.setParentesco(mapper.pessoaDTOToPessoa(pessoaDTO).getParentesco());
        });
    }

    public void deletaPessoa(Long id) throws IllegalArgumentException {
        this.repository.deleteById(id);
    }

    public void associaPessoaParente(Long pessoaId, Long parenteId, TipoParentesco tipoParentesco) throws AssociationException {
        try {
            var pessoa = this.listaPessoa(pessoaId);
            var parente = this.listaPessoa(parenteId);
            var parenteEntity = Parentesco.builder()
                    .tipoParentesco(tipoParentesco)
                    .pessoa(pessoa)
                    .pessoaComParentesco(parente)
                    .build();

            this.parentescoRepository.save(parenteEntity);
            pessoa.getParentesco().add(parenteEntity);

            this.repository.save(pessoa);
        } catch (NoSuchElementException e) {
            throw new AssociationException("Erro ao associar pessoa com parente");
        }
    }

    public void associaPessoaEndereco(Long pessoaId, Long enderecoId) throws AssociationException {
        try {
            var pessoa = this.listaPessoa(pessoaId);
            var endereco = this.enderecoService.listaEndereco(enderecoId);

            pessoa.getEnderecos().add(endereco);
            this.repository.save(pessoa);
        } catch (NoSuchElementException e) {
            throw new AssociationException("Erro ao associar pessoa com endereco");
        }
    }

    public void associaPessoaEletrodomestico(Long pessoaId, Long eletrodomesticoId) throws AssociationException {
        try {
            var pessoa = this.listaPessoa(pessoaId);
            var eletrodomestico = this.eletrodomesticoService.listaEletrodomesticoSemConsumo(eletrodomesticoId);

            pessoa.getEletrodomesticos().add(eletrodomestico);
            this.repository.save(pessoa);
        } catch (NoSuchElementException e) {
            throw new AssociationException("Erro ao associar pessoa com eletrodomestico");
        }
    }

}

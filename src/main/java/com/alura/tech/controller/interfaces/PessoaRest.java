package com.alura.tech.controller.interfaces;

import com.alura.tech.entities.enums.TipoParentesco;
import com.alura.tech.model.PessoaDTO;
import com.alura.tech.model.response.PessoaCompletoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/people")
@Tag(name = "Pessoas", description = "Gerenciamento de pessoas")
public interface PessoaRest {

    @GetMapping
    @Operation(description = "Lista todas as pessoas")
    @ApiResponse(responseCode = "200", description = "Pessoas listadas com sucesso")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    ResponseEntity<List<PessoaCompletoDTO>> listaPessoas();

    @PostMapping("/search")
    @Operation(description = "Busca as pessoas")
    @ApiResponse(responseCode = "200", description = "Pessoas buscadas com sucesso")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    ResponseEntity<List<PessoaCompletoDTO>> buscaPessoas(@RequestBody @Valid PessoaDTO pessoaDTO);

    @GetMapping("/{id}")
    @Operation(description = "Lista uma pessoa")
    @ApiResponse(responseCode = "200", description = "Pessoa listada com sucesso")
    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    ResponseEntity<PessoaCompletoDTO> listaPessoa(@PathVariable("id") Long id);

    @PostMapping
    @Operation(description = "Cadastra nova pessoa")
    @ApiResponse(responseCode = "200", description = "Pessoa cadastrada com sucesso")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    ResponseEntity<?> cadastraPessoa(@RequestBody @Valid PessoaDTO pessoaDTO);

    @PutMapping("/{id}")
    @Operation(description = "Atualiza uma pessoa")
    @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    ResponseEntity<?> atualizaPessoa(@RequestBody @Valid PessoaDTO pessoaDTO, @PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    @Operation(description = "Deleta uma pessoa")
    @ApiResponse(responseCode = "204", description = "Pessoa excluida com sucesso")
    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    ResponseEntity<?> deletaPessoa(@PathVariable("id") Long id);

    @PostMapping("/{pessoaId}/eletrodomestico/{eletrodomesticoId}")
    @Operation(description = "Associa pessoa a eletrodomestico")
    @ApiResponse(responseCode = "200", description = "Associação realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    ResponseEntity<Void> associaPessoaEletrodomestico(@PathVariable Long pessoaId, @PathVariable Long eletrodomesticoId);

    @PostMapping("/{pessoaId}/endereco/{enderecoId}")
    @Operation(description = "Associa pessoa a endereco")
    @ApiResponse(responseCode = "200", description = "Associação realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    ResponseEntity<Void> associaPessoaEndereco(@PathVariable Long pessoaId, @PathVariable Long enderecoId);

    @PostMapping("/{pessoaId}/relative/{parenteId}")
    @Operation(description = "Associa pessoa a endereco")
    @ApiResponse(responseCode = "200", description = "Associação realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    ResponseEntity<Void> associaPessoaParente(@PathVariable Long pessoaId, @PathVariable Long parenteId, @RequestParam TipoParentesco tipoParentesco);

}

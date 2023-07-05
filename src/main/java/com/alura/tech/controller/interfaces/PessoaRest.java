package com.alura.tech.controller.interfaces;

import com.alura.tech.model.PessoaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/people")
@Tag(name = "Pessoas", description = "Gerenciamento de pessoas")
public interface PessoaRest {

    @GetMapping
    @Operation(description = "Lista todas as pessoas")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pessoas listadas com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> listaPessoas();

    @GetMapping("/{id}")
    @Operation(description = "Lista uma pessoa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pessoa listada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> listaPessoa(@PathVariable("id") UUID id);

    @PostMapping
    @Operation(description = "Cadastra nova pessoa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pessoa cadastrada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> cadastraPessoa(@RequestBody @Valid PessoaDTO pessoaDTO);

    @PutMapping("/{id}")
    @Operation(description = "Atualiza uma pessoa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> atualizaPessoa(@RequestBody @Valid PessoaDTO pessoaDTO, @PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    @Operation(description = "Deleta uma pessoa")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Pessoa excluida com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> deletaPessoa(@PathVariable("id") UUID id);

}

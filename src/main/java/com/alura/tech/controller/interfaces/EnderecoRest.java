package com.alura.tech.controller.interfaces;

import com.alura.tech.entities.Endereco;
import com.alura.tech.model.EnderecoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

import java.util.List;

@RequestMapping("/api/address")
@Tag(name = "Endereço", description = "Gerenciamento de endereços")
public interface EnderecoRest {

    @GetMapping
    @Operation(description = "Lista todos os endereços")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Endereços listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> listaEnderecos();

    @GetMapping("/{id}")
    @Operation(description = "Lista um endereço")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Endereço listado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> listaEndereco(@PathVariable("id") Long id);

    @PostMapping("/search")
    @Operation(description = "Busca endereços")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<List<Endereco>> buscaEnderecos(@RequestBody @Valid EnderecoDTO enderecoDTO);

    @PostMapping
    @Operation(description = "Cadastra novo endereço")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Endereço cadastrado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> cadastraEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO);

    @PutMapping("/{id}")
    @Operation(description = "Atualiza um endereço")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> atualizaEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO, @PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    @Operation(description = "Deleta um endereço")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Endereço excluido com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<String> deletaEndereco(@PathVariable("id") Long id);
}


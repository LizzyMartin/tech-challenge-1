package com.alura.tech.controller.interfaces;

import com.alura.tech.model.EnderecoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    ResponseEntity<?> listaEndereco(@PathVariable("id") UUID id);

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
    ResponseEntity<?> atualizaEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO, @PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    @Operation(description = "Deleta um endereço")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Endereço excluido com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> deletaEndereco(@PathVariable("id") UUID id);
}


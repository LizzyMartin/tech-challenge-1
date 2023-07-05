package com.alura.tech.controller.interfaces;

import com.alura.tech.model.EletrodomesticoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/homeappliance")
@Tag(name = "Eletrodomesticos", description = "Gerenciamento de eletrodomesticos")
public interface EletrodomesticosRest {

    @GetMapping
    @Operation(description = "Lista todos os eletrodomesticos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Eletrodomesticos listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> listaEletrodomesticos();

    @GetMapping("/{id}")
    @Operation(description = "Lista um eletrodomestico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Eletrodomestico listado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> listaEletrodomestico(@PathVariable("id") UUID id);

    @PostMapping
    @Operation(description = "Cadastra novo eletrodomestico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Eletrodomestico cadastrado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> cadastraEletrodomestico(@RequestBody @Valid EletrodomesticoDTO eletrodomesticoDTO);

    @PutMapping("/{id}")
    @Operation(description = "Atualiza um eletrodomestico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Eletrodomestico atualizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> atualizaEletrodomestico(@RequestBody @Valid EletrodomesticoDTO eletrodomesticoDTO, @PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    @Operation(description = "Deleta um eletrodomestico")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Eletrodomestico excluido com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> deletaEletrodomestico(@PathVariable("id") UUID id);

}

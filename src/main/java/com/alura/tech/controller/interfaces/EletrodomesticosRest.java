package com.alura.tech.controller.interfaces;

import com.alura.tech.model.EletrodomesticoDTO;
import com.alura.tech.model.response.EletrodomesticoConsumoDTO;
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

@RequestMapping("/api/homeappliance")
@Tag(name = "Eletrodomesticos", description = "Gerenciamento de eletrodomesticos")
public interface EletrodomesticosRest {

    @GetMapping
    @Operation(description = "Lista todos os eletrodomesticos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Eletrodomesticos listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<List<EletrodomesticoConsumoDTO>> listaEletrodomesticos();

    @GetMapping("/{id}")
    @Operation(description = "Lista um eletrodomestico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Eletrodomestico listado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<EletrodomesticoConsumoDTO> listaEletrodomestico(@PathVariable("id") Long id);

    @PostMapping("/search")
    @Operation(description = "Busca eletrodomesticos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Eletrodomesticos listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<List<EletrodomesticoConsumoDTO>> buscaEletrodomesticos(@RequestBody EletrodomesticoDTO eletrodomesticoDTO);

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
    ResponseEntity<?> atualizaEletrodomestico(@RequestBody @Valid EletrodomesticoDTO eletrodomesticoDTO, @PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    @Operation(description = "Deleta um eletrodomestico")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Eletrodomestico excluido com sucesso"),
            @ApiResponse(responseCode = "500", description = "Bad Request")
    })
    ResponseEntity<?> deletaEletrodomestico(@PathVariable("id") Long id);

}

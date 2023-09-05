package com.alura.tech.repository;

import com.alura.tech.entities.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EletrodomesticosRepository extends JpaRepository<Eletrodomestico, Long> {

    List<Eletrodomestico> findAllByNome(String nome);

    List<Eletrodomestico> findAllByModelo(String modelo);

    List<Eletrodomestico> findAllByPotencia(String potencia);

}

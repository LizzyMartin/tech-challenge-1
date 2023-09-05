package com.alura.tech.repository;

import com.alura.tech.entities.Pessoa;
import com.alura.tech.entities.enums.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findAllByNome(String nome);

    List<Pessoa> findAllBySexo(Genero sexo);
}

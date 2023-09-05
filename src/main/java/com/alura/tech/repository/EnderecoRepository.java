package com.alura.tech.repository;

import com.alura.tech.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findAllByRua(String rua);

    List<Endereco> findAllByBairro(String bairro);

    List<Endereco> findAllByCidade(String cidade);

    List<Endereco> findAllByEstado(String estado);

}

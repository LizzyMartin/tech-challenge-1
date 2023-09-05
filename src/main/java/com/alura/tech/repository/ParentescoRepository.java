package com.alura.tech.repository;

import com.alura.tech.entities.Parentesco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentescoRepository extends JpaRepository<Parentesco, Long> {
}

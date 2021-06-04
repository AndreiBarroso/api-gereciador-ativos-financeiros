package com.teste.andreibarroso.domain.repository;

import com.teste.andreibarroso.domain.model.MovimentacaoAtivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoAtivoRepository extends JpaRepository<MovimentacaoAtivo, Long> {
}

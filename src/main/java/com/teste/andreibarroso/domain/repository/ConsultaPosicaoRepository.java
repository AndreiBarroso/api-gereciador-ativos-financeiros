package com.teste.andreibarroso.domain.repository;

import com.teste.andreibarroso.domain.model.ConsultaPosicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaPosicaoRepository extends JpaRepository<ConsultaPosicao, Long> {
}

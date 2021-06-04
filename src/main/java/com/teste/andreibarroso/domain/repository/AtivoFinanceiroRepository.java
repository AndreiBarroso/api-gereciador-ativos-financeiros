package com.teste.andreibarroso.domain.repository;

import com.teste.andreibarroso.domain.model.AtivoFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtivoFinanceiroRepository extends JpaRepository<AtivoFinanceiro, Long> {
    void delete(Optional<AtivoFinanceiro> byId);
}

package com.teste.andreibarroso.domain.service;

import com.teste.andreibarroso.domain.model.AtivoFinanceiro;
import com.teste.andreibarroso.domain.repository.AtivoFinanceiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtivoFinanceiroService {

    private final AtivoFinanceiroRepository repository;


    public AtivoFinanceiroService(AtivoFinanceiroRepository repository) {
        this.repository = repository;
    }

    private AtivoFinanceiro create (AtivoFinanceiro data) {
        return repository.save(data);
    }

    private Optional<AtivoFinanceiro> findById (Long id) {
        return repository.findById(id);
    }

    private List<AtivoFinanceiro> findAll () {
        return repository.findAll();
    }

    private void delete (Long id) {
        Optional<AtivoFinanceiro> byId = repository.findById(id);
        repository.delete(byId);
    }

    private void updateAtivo (AtivoFinanceiro data) {
        Optional<AtivoFinanceiro> byId = findById(data.getId());
        repository.save(data);
    }
}

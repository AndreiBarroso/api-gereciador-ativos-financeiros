package com.teste.andreibarroso.domain.service;

import com.teste.andreibarroso.domain.model.Pessoa;
import com.teste.andreibarroso.domain.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    private final PessoaRepository repository;

    private Pessoa create (Pessoa data) {
      return repository.save(data);
    }

    private Optional<Pessoa> findById (Long id) {
        return repository.findById(id);
    }

}

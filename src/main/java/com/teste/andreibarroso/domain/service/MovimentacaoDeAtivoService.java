package com.teste.andreibarroso.domain.service;

import com.teste.andreibarroso.domain.model.MovimentacaoAtivo;
import com.teste.andreibarroso.domain.repository.MovimentacaoAtivoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class MovimentacaoDeAtivoService {

    public MovimentacaoDeAtivoService(MovimentacaoAtivoRepository repository) {
        this.repository = repository;
    }

    private final MovimentacaoAtivoRepository repository;

    @Transactional
    public MovimentacaoAtivo compra(MovimentacaoAtivo data) {
        verificasaldo(data);
        if (data.getCompra().compareTo(BigDecimal.ZERO) > 0 & data.getAtivoFinanceiro().getQtdAtivo() > 0) {
            BigDecimal lancamentoSaida = data.getContaCorrente().getSaldo();
            BigDecimal subtract = data.getCompra().subtract(lancamentoSaida);
            data.getContaCorrente().setLancamentoSaida(subtract);
            data.getAtivoFinanceiro().setQtdAtivo(data.getAtivoFinanceiro().getQtdAtivo() - data.getQtd());
        }
        return repository.save(data);
    }

    public void verificasaldo(MovimentacaoAtivo data) {
        if (data.getContaCorrente().getSaldo().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException();
        }

    }

    @Transactional
    public MovimentacaoAtivo venda(MovimentacaoAtivo data) {
        verificaQtdAtivos(data);
        if (data.getVenda().compareTo(BigDecimal.ZERO) > 0 & data.getQtd() > data.getVenda().longValue()) {
            BigDecimal lancamentoEntrada = data.getContaCorrente().getSaldo();
            BigDecimal soma = data.getVenda().add(lancamentoEntrada);
            data.getContaCorrente().setLancamentoEntrada(soma);
            data.getAtivoFinanceiro().setQtdAtivo(data.getAtivoFinanceiro().getQtdAtivo() + data.getQtd());
        }
        return repository.save(data);
    }


    public void verificaQtdAtivos(MovimentacaoAtivo data) {
        if (data.getAtivoFinanceiro().getQtdAtivo() < 0) {
            throw new RuntimeException();
        }

    }
}
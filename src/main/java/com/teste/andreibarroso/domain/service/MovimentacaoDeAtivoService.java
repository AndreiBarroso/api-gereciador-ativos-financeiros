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
        verificaQtdAtivos(data);
        verificasaldo(data);
        if (data.getCompra().compareTo(BigDecimal.ZERO) > 0 & data.getAtivoFinanceiro().getQtdAtivo() > 0) {
            BigDecimal lancamentoSaida = data.getCompra();
            BigDecimal saldo = data.getContaCorrente().getSaldo();
            data.getContaCorrente().setSaldo(saldo.subtract(lancamentoSaida));
            data.getContaCorrente().setLancamentoSaida(lancamentoSaida);
            data.getAtivoFinanceiro().setQtdAtivo(data.getAtivoFinanceiro().getQtdAtivo() - data.getQtd());
            data.setValorMovimentacao(lancamentoSaida);
        }
        return repository.save(data);
    }

    public void verificasaldo(MovimentacaoAtivo data) {
        if (data.getContaCorrente().getSaldo().longValue() < data.getCompra().longValue()) {
            throw new RuntimeException();
        }
    }

    @Transactional
    public MovimentacaoAtivo venda(MovimentacaoAtivo data) {
        verificaQtdAtivos(data);
        if (data.getVenda().compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal lancamentoEntrada = data.getVenda();
            BigDecimal saldo = data.getContaCorrente().getSaldo();
            data.getContaCorrente().setSaldo(saldo.add(lancamentoEntrada));
            data.getContaCorrente().setLancamentoEntrada(lancamentoEntrada);
            data.getAtivoFinanceiro().setQtdAtivo(data.getAtivoFinanceiro().getQtdAtivo() + data.getQtd());
            data.setValorMovimentacao(lancamentoEntrada);
        }
        return repository.save(data);
    }


    public void verificaQtdAtivos(MovimentacaoAtivo data) {
        if (data.getAtivoFinanceiro().getQtdAtivo() < data.getQtd()) {
            throw new RuntimeException();
        }

    }
}
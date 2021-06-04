package com.teste.andreibarroso.domain.service;

import com.teste.andreibarroso.domain.model.AtivoFinanceiro;
import com.teste.andreibarroso.domain.model.ContaCorrente;
import com.teste.andreibarroso.domain.model.MovimentacaoAtivo;
import com.teste.andreibarroso.domain.model.Pessoa;
import com.teste.andreibarroso.domain.model.enums.AplicacaoFinanceira;
import com.teste.andreibarroso.domain.repository.MovimentacaoAtivoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MovimentacaoDeAtivoServiceTest {

    @Mock
    private MovimentacaoAtivoRepository repository;

    @InjectMocks
    private MovimentacaoDeAtivoService service;

    @Test
    public void testCompra () {
        ContaCorrente contaCorrente = ContaCorrente.builder()
                .saldo(BigDecimal.valueOf(30))
                .build();

        Pessoa pessoa = Pessoa.builder()
                .id(1L)
                .contaCorrente(contaCorrente)
                .cpf("324732643264")
                .nome("ANDREI MESQUITA BARROSO")
                .build();

        AtivoFinanceiro ativoFinanceiro = AtivoFinanceiro.builder()
                .id(1L)
                .nome("PETROBRAS")
                .qtdAtivo(100L)
                .precoMercado(BigDecimal.valueOf(100.00))
                .aplicacaoFinanceira(AplicacaoFinanceira.RV)
                .build();


        MovimentacaoAtivo movimentacaoAtivo = MovimentacaoAtivo.builder()
                .contaCorrente(contaCorrente)
                .ativoFinanceiro(ativoFinanceiro)
                .qtd(10L)
                .compra(BigDecimal.valueOf(20))
                .build();

        service.compra(movimentacaoAtivo);
        verify(repository, times(1)).save(movimentacaoAtivo);
        System.out.println(pessoa.getContaCorrente().getLancamentoSaida());
        System.out.println(pessoa.getContaCorrente().getSaldo());
        System.out.println(ativoFinanceiro.getQtdAtivo());
        System.out.println(movimentacaoAtivo.getValorMovimentacao());

    }

    @Test
    public void testVenda () {

    }
}
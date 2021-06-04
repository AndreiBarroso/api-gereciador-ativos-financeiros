package com.teste.andreibarroso.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ContaCorrente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

    private BigDecimal saldo;

    @PositiveOrZero
    private BigDecimal lancamentoEntrada = BigDecimal.ZERO;

    @PositiveOrZero
    private BigDecimal lancamentoSaida = BigDecimal.ZERO;

    @OneToMany
    private List<MovimentacaoAtivo> movimentacaoAtivoList;
}

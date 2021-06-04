package com.teste.andreibarroso.domain.model;

import com.teste.andreibarroso.domain.model.enums.AplicacaoFinanceira;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AtivoFinanceiro {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

    @NotNull
    private String nome;

    @PositiveOrZero
    @NotNull
    private BigDecimal precoMercado = BigDecimal.ZERO;

    private Long qtdAtivo;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AplicacaoFinanceira aplicacaoFinanceira;

    @OneToOne
    private ConsultaPosicao posicao;

}

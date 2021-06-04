package com.teste.andreibarroso.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MovimentacaoAtivo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

    private Long qtd;

    private BigDecimal valorMovimentacao;

    private BigDecimal compra;

    private BigDecimal venda;

    @ManyToOne
    private ContaCorrente contaCorrente;

    @OneToOne
    private AtivoFinanceiro ativoFinanceiro;

}

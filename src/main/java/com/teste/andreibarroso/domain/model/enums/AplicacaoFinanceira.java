package com.teste.andreibarroso.domain.model.enums;

public enum AplicacaoFinanceira {


    RV(1, "RENDA VARIAVEL"),
    RF(2, "RENDA FIXA"),
    FI(3, "FUNDO DE INVESTIMENTO");

    private int cod;
    private String descricao;

    private AplicacaoFinanceira(int cod, String descricao) {
        this.cod= cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static AplicacaoFinanceira toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (AplicacaoFinanceira x : AplicacaoFinanceira.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}

package model.entities;

import java.time.LocalDate;

public class Parcela {

    private final Double valorParcela;
    private final LocalDate vencimentoParcela;

    public Parcela(Double valorParcela, LocalDate vencimentoParcela) {
        this.valorParcela = valorParcela;
        this.vencimentoParcela = vencimentoParcela;
    }

    public Double getValorParcela() {
        return valorParcela;
    }

    public LocalDate getVencimentoParcela() {
        return vencimentoParcela;
    }

    @Override
    public String toString() {
        return "Valor da Parcela: R$" + valorParcela + ", Vencimento Parcela: " + vencimentoParcela;
    }

}

package domain.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import domain.entities.contrato.ContratoAbstrato;

public class ServiceContrato<T extends ContratoAbstrato> {

    private List<ContratoAbstrato> contratos = new ArrayList<>();

    public ServiceContrato(List<ContratoAbstrato> contratos) {
        this.contratos = contratos;
    }

    public BigDecimal getValorTotalLiquido() {
        BigDecimal totalLiquido = BigDecimal.ZERO;

        for (ContratoAbstrato contrato : contratos) {
            totalLiquido = totalLiquido.add(contrato.getSalarioLiquido());
        }

        return totalLiquido;
    }
}

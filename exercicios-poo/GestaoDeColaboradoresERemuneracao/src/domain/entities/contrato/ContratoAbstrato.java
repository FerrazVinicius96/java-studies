package domain.entities.contrato;

import java.math.BigDecimal;
import java.time.LocalDate;

import domain.entities.imposto.ImpostoInterface;
import domain.model.enums.ContratoEnum;

public abstract class ContratoAbstrato {

    private final Long idContrato;

    private String descricaoContrato;
    private LocalDate dataInicioContrato;
    private LocalDate dataTerminoContrato;

    private BigDecimal salarioBruto;

    private final ContratoEnum especieContrato;

    private ImpostoInterface imposto;

    public ContratoAbstrato(Long idContrato, String descricaoContrato,
            LocalDate dataInicioContrato, BigDecimal salarioBruto, ContratoEnum especieContrato,
            ImpostoInterface imposto) {
        this.idContrato = idContrato;
        this.descricaoContrato = descricaoContrato;
        this.dataInicioContrato = dataInicioContrato;
        this.salarioBruto = salarioBruto;
        this.especieContrato = especieContrato;
        this.imposto = imposto;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public String getDescricaoContrato() {
        return descricaoContrato;
    }

    public void setDescricaoContrato(String descricaoContrato) {
        this.descricaoContrato = descricaoContrato;
    }

    public LocalDate getDataInicioContrato() {
        return dataInicioContrato;
    }

    public void setDataInicioContrato(LocalDate dataInicioContrato) {
        this.dataInicioContrato = dataInicioContrato;
    }

    public LocalDate getDataTerminoContrato() {
        return dataTerminoContrato;
    }

    public void setDataTerminoContrato(LocalDate dataTerminoContrato) {
        this.dataTerminoContrato = dataTerminoContrato;
    }

    public BigDecimal getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(BigDecimal salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public ContratoEnum getEspecieContrato() {
        return especieContrato;
    }

    public BigDecimal getValorImposto() {
        return imposto.calculoImposto(this.salarioBruto);
    }

    public BigDecimal getSalarioLiquido() {
        return getSalarioBruto().subtract(getValorImposto());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idContrato == null) ? 0 : idContrato.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContratoAbstrato other = (ContratoAbstrato) obj;
        if (idContrato == null) {
            if (other.idContrato != null)
                return false;
        } else if (!idContrato.equals(other.idContrato))
            return false;
        return true;
    }

}

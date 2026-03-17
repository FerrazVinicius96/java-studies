package domain.entities.contrato;

import java.math.BigDecimal;
import java.time.LocalDate;

import domain.entities.imposto.ImpostoClt;
import domain.model.enums.ContratoEnum;

public class ContratoClt extends ContratoAbstrato {

    public ContratoClt(long idContrato, String descricaoContrato, LocalDate dataInicioContrato,
            BigDecimal remuneracao, ImpostoClt imposto) {
        super(idContrato, descricaoContrato, dataInicioContrato, remuneracao,
                ContratoEnum.CLT, imposto);
    }

    @Override
    public String toString() {
        return "Contrato CLT:\nID: " + this.getIdContrato();
    }

}

package domain.entities.contrato;

import java.math.BigDecimal;
import java.time.LocalDate;

import domain.entities.imposto.ImpostoPj;
import domain.model.enums.ContratoEnum;

public class ContratoPj extends ContratoAbstrato {

    public ContratoPj(long idContrato, String descricaoContrato, LocalDate dataInicioContrato,
            BigDecimal remuneracao, ImpostoPj imposto) {
        super(idContrato, descricaoContrato, dataInicioContrato, remuneracao,
                ContratoEnum.PJ, imposto);
    }

}

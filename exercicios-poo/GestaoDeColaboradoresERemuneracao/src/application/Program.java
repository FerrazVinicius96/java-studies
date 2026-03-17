package application;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.entities.contrato.ContratoAbstrato;
import domain.entities.contrato.ContratoClt;
import domain.entities.contrato.ContratoPj;
import domain.entities.imposto.ImpostoClt;
import domain.entities.imposto.ImpostoPj;
// import domain.entities.trabalhador.Trabalhador;
import domain.services.ServiceContrato;

public class Program {
    public static void main(String[] args) {

        // Trabalhador t1 = new Trabalhador(1, "111.111.111-00", "João", "Silva",
        // "Dev");
        ContratoAbstrato c1 = new ContratoClt(10, "Dev Jr.", LocalDate.parse("2026-03-17"),
                new BigDecimal("10000.00"), new ImpostoClt());
        ContratoAbstrato c2 = new ContratoPj(12, "Dev Sr.", LocalDate.parse("2026-02-28"), new BigDecimal("5000.00"),
                new ImpostoPj());

        List<ContratoAbstrato> contratos = new ArrayList<ContratoAbstrato>();
        contratos.add(c1);
        contratos.add(c2);

        ServiceContrato<ContratoAbstrato> servContrato = new ServiceContrato<>(contratos);

        System.out.println(servContrato.getValorTotalLiquido());
    }
}

package domain.entities.imposto;

import java.math.BigDecimal;

public class ImpostoPj implements ImpostoInterface {

    private static final BigDecimal aliquota = new BigDecimal("0.075");

    public BigDecimal calculoImposto(BigDecimal salarioBruto) {
        return salarioBruto.multiply(aliquota);
    }
}

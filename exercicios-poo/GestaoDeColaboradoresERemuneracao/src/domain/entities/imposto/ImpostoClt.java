package domain.entities.imposto;

import java.math.BigDecimal;

public class ImpostoClt implements ImpostoInterface {

    private static final BigDecimal aliquota = new BigDecimal("0.275");

    public BigDecimal calculoImposto(BigDecimal salarioBruto) {
        return salarioBruto.multiply(aliquota);
    }
}

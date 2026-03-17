package domain.entities.imposto;

import java.math.BigDecimal;

public interface ImpostoInterface {
    BigDecimal calculoImposto(BigDecimal salarioBruto);
}

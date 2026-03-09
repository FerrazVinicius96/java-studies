package model.services;

public class PaymentProcessor {

    // O serviço mantém apenas a dependência da interface
    private CurrencyConverter currencyConverter;

    // Injeção de dependência via construtor
    public PaymentProcessor(CurrencyConverter currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    // O valor entra como parâmetro do método, tornando o serviço reutilizável
    public double processPayment(double amount) {
        return currencyConverter.convert(amount);
    }
}
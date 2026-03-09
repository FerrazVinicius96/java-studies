package model.services;

public class DollarConverter implements CurrencyConverter {
    // Definimos como constante (static final) pois a taxa é fixa para esta classe
    private static final double EXCHANGE_RATE = 5.0;

    @Override
    public double convert(double amount) {
        return amount * EXCHANGE_RATE;
    }
}
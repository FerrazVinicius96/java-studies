package model.services;

public class EuroConverter implements CurrencyConverter {

    private final Double exchangeRate = 5.5;

    public double convert(double amount) {
        return amount * exchangeRate;
    }
}

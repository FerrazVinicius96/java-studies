package application;

import model.services.*;

public class Program {
    public static void main(String[] args) {

        double saleValue = 550.50;

        // Injetamos a implementação de Dólar
        PaymentProcessor pp = new PaymentProcessor(new DollarConverter());

        System.out.printf("Valor final: R$ %.2f%n", pp.processPayment(saleValue));

        // Veja a vantagem: se precisasse mudar para Euro, o serviço pp continua o mesmo
        // basta injetar uma nova implementação.
    }
}
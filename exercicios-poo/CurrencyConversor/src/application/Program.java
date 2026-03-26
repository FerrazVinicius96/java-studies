package application;

import model.services.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        boolean programOn = true;

        while (programOn) {
            try {
                System.out.print("\nInsira o valor que deseja converter: ");
                double saleValue = sc.nextDouble();

                System.out.print("Opções:\n1- Dólar para Real\n2- Euro para Real\n0- Sair\nEscolha: ");
                int opcaoConver = sc.nextInt();

                if (opcaoConver == 0) {
                    System.out.println("Programa encerrado.");
                    programOn = false;
                    break;
                }

                PaymentProcessor pp;
                switch (opcaoConver) {
                    case 1:
                        pp = new PaymentProcessor(new DollarConverter());
                        System.out.printf("Valor final: R$ %.2f%n", pp.processPayment(saleValue));
                        break;
                    case 2:
                        pp = new PaymentProcessor(new EuroConverter());
                        System.out.printf("Valor final: R$ %.2f%n", pp.processPayment(saleValue));
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números válidos.");
                sc.nextLine();
            }
        }

        sc.close();
    }
}
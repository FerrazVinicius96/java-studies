package application;

import model.entities.Vehicle;
import model.services.ParkingLot;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLot parking = new ParkingLot();
        int opt;

        do {
            System.out.print("\n1-Check-in\n2-Check-out\n3-Listar\n0-Sair\nOpção: ");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    System.out.print("Placa: ");
                    String plate = sc.nextLine();
                    System.out.print("Modelo: ");
                    String model = sc.nextLine();
                    parking.checkIn(new Vehicle(plate, model));
                    break;
                case 2:
                    System.out.print("Digite a placa para saída: ");
                    String p = sc.nextLine();
                    parking.checkOut(p);
                    break;
                case 3:
                    parking.listVehicles();
                    break;
            }
        } while (opt != 0);

        sc.close();
    }
}

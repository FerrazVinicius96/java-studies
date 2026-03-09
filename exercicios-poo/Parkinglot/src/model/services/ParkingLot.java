package model.services;

import model.entities.Vehicle;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Vehicle> vehicles = new ArrayList<>();
    private static final double PRICE_PER_HOUR = 10.0;

    public void checkIn(Vehicle v) {
        vehicles.add(v);
        System.out.println("Veículo " + v.getPlate() + " estacionado.");
    }

    public void checkOut(String plate) {
        // Busca o veículo pela placa usando Stream
        Vehicle v = vehicles.stream()
                .filter(x -> x.getPlate().equalsIgnoreCase(plate))
                .findFirst()
                .orElse(null);

        if (v != null) {
            LocalDateTime exitTime = LocalDateTime.now();

            // Simulação: Se quiser testar períodos maiores, você pode subtrair horas
            // manualmente:
            // LocalDateTime entry = v.getEntryTime().minusHours(2);

            Duration duration = Duration.between(v.getEntryTime(), exitTime);

            // Cálculo: pegamos os minutos e convertemos para horas (mínimo 1h)
            long minutes = duration.toMinutes();
            double hours = Math.max(1.0, Math.ceil(minutes / 60.0));
            double bill = hours * PRICE_PER_HOUR;

            System.out.println("--- COMPROVANTE ---");
            System.out.println("Veículo: " + v.getModel() + " [" + v.getPlate() + "]");
            System.out.println("Permanência: " + minutes + " minutos (" + hours + "h cobradas)");
            System.out.printf("Valor Total: R$ %.2f%n", bill);

            vehicles.remove(v); // Libera a vaga
        } else {
            System.out.println("Erro: Veículo com placa " + plate + " não encontrado.");
        }
    }

    public void listVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("Estacionamento vazio.");
        } else {
            vehicles.forEach(System.out::println);
        }
    }
}

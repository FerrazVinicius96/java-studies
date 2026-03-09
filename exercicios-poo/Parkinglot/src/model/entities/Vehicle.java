package model.entities;

import java.time.LocalDateTime;

public class Vehicle {
    private String plate;
    private String model;
    private LocalDateTime entryTime;

    public Vehicle(String plate, String model) {
        this.plate = plate;
        this.model = model;
        this.entryTime = LocalDateTime.now(); // Registra a hora exata da entrada
    }

    public String getPlate() {
        return plate;
    }

    public String getModel() {
        return model;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return "Modelo: " + model + " | Placa: " + plate + " | Entrada: " + entryTime;
    }
}
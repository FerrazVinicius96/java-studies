package model.entities;

public class Employee {
    private String name;
    private Integer hours;
    private Double valuePerHour;

    public Employee(String name, Integer hours, Double valuePerHour) {
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public String getName() {
        return name;
    }

    public Double payment() {
        return hours * valuePerHour;
    }

    @Override
    public String toString() {
        return name + " - R$ " + String.format("%.2f", payment());
    }
}
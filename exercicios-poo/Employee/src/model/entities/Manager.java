package model.entities;

public class Manager extends Employee {
    private Double teamBonus;

    public Manager(String name, Integer hours, Double valuePerHour, Double teamBonus) {
        super(name, hours, valuePerHour); // Chama o construtor da classe pai
        this.teamBonus = teamBonus;
    }

    @Override
    public Double payment() {
        // Aproveita o cálculo base e adiciona o bônus
        return super.payment() + teamBonus;
    }
}
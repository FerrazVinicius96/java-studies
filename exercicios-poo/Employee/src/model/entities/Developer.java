package model.entities;

public class Developer extends Employee {
    private Double certificationAllowance;

    public Developer(String name, Integer hours, Double valuePerHour, Double certificationAllowance) {
        super(name, hours, valuePerHour);
        this.certificationAllowance = certificationAllowance;
    }

    @Override
    public Double payment() {
        return super.payment() + certificationAllowance;
    }
}

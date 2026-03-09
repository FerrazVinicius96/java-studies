package model.services;

import model.entities.Employee;
import java.util.ArrayList;
import java.util.List;

public class PayrollService {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee emp : employees) {
            // POLIMORFISMO: O Java decide em tempo de execução qual payment() chamar
            total += emp.payment();
        }
        return total;
    }

    public void showReport() {
        System.out.println("\n--- RELATÓRIO DE PAGAMENTOS ---");
        employees.forEach(System.out::println);
    }
}
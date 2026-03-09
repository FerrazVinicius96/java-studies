package application;

import model.entities.*;
import model.services.PayrollService;

public class Program {
    public static void main(String[] args) {
        PayrollService payroll = new PayrollService();

        // Upcasting: tratando objetos específicos como o tipo genérico Employee
        payroll.addEmployee(new Employee("João Silva", 160, 50.0));
        payroll.addEmployee(new Manager("Maria Tech", 160, 80.0, 2000.0));
        payroll.addEmployee(new Developer("Dev Carlos", 170, 60.0, 500.0));

        payroll.showReport();
        System.out.printf("%nTotal da Folha Mensal: R$ %.2f%n", payroll.calculateTotalPayroll());
    }
}
package Entities;

public class FixedSalaryEmployee extends Employee {
    private double monthlyRate;

    public FixedSalaryEmployee(String firstName, String secondName, double monthlyRate) {
        super(firstName, secondName);
        this.monthlyRate = monthlyRate;
    }

    @Override
    public double calculateSalary() {
        return monthlyRate;
    }
}

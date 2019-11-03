package Entities;

public class Freelancer extends Employee {
    private double hourlyRate;
    private int hours;

    public Freelancer(String firstName, String secondName, double hourlyRate, int hours) {
        super(firstName, secondName);
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hours;
    }
}


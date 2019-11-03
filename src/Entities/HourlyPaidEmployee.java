package Entities;

public class HourlyPaidEmployee extends Employee {
    private int numberOfWorkingDays;
    private int numberOfHours;
    private double rate;

    public HourlyPaidEmployee(String firstName, String secondName, int numberOfWorkingDays, int numberOfHours, double rate) {
        super(firstName, secondName);
        this.numberOfWorkingDays = numberOfWorkingDays;
        this.numberOfHours = numberOfHours;
        this.rate = rate;
    }

    @Override
    public double calculateSalary() {
        return numberOfWorkingDays * numberOfHours * rate;
    }
}

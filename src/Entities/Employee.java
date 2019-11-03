package Entities;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    private String firstName;
    private String secondName;

    public Employee(String firstName, String secondName) {

        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public abstract double calculateSalary();
}

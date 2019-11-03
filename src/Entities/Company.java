package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Company implements Serializable {
    private ArrayList<Employee> employees = new ArrayList<>();

    {
        employees.add(new FixedSalaryEmployee("Sonya", "Vyshgorodskaya", 45000));
        employees.add(new HourlyPaidEmployee("Murka", "Vynogradova", 8, 4, 1000));
        employees.add(new Freelancer("Mustafa", "Abalduev", 300, 35));
        employees.add(new Freelancer("Musya", "Zabolotnaya", 500, 40));
        employees.add(new Freelancer("Snezhana", "Egorova", 560, 25));
        employees.add(new Freelancer("Arnold", "Kalashnikov", 300, 23));
    }

    public void addNewEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("new employee has been added: " + employee.getFirstName() + ", " + employee.getSecondName() + ", " + employee.getClass().getSimpleName());
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public double calculateCosts() {
        double costs = 0;
        for (int i = 0; i < employees.size(); i++) {
            costs += employees.get(i).calculateSalary();
        }
        return costs;
    }

    public void getEmployeesInfo() {
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("Entities.Employee " + i + ": " + employees.get(i).getFirstName() + " " + employees.get(i).getSecondName() + ", " + employees.get(i).getClass().getSimpleName() + ", salary: " + employees.get(i).calculateSalary());
        }
    }

    public void registerNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To register new Employee, enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.println("Select: 0 - Fixed Salary, 1 - Hourly Paid, 2 - Freelancer Employee: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 0: {
                boolean isNegative = true;
                while (isNegative) {
                    System.out.println("Enter Monthly Rate: ");
                    double rate = scanner.nextDouble();
                    if (rate < 0) {
                        System.out.println("Rate can't be less than 0");
                    } else {
                        FixedSalaryEmployee fixedSalaryEmployee = new FixedSalaryEmployee(firstName, lastName, rate);
                        addNewEmployee(fixedSalaryEmployee);
                        isNegative = false;
                    }

                }
                break;
            }
            case 1: {
                boolean isNegative = true;
                while (isNegative) {
                    System.out.println("Enter number of working days: ");
                    int numberOfDays = scanner.nextInt();
                    System.out.println("Enter number of hours: ");
                    int numberOfHours = scanner.nextInt();
                    System.out.println("Enter rate: ");
                    double rate = scanner.nextDouble();
                    if (numberOfDays < 0 || numberOfHours < 0 || rate < 0) {
                        System.out.println("Incorrect input. Number of Days, number of Hours or Rate can't be less than 0");
                    } else {
                        HourlyPaidEmployee hourlyPaidEmployee = new HourlyPaidEmployee(firstName, lastName, numberOfDays, numberOfHours, rate);
                        addNewEmployee(hourlyPaidEmployee);
                        isNegative = false;
                    }
                }
                break;
            }
            case 2: {
                boolean isNegative = true;
                while (isNegative) {
                    System.out.println("Enter Hourly Rate: ");
                    double rate = scanner.nextDouble();
                    System.out.println("Enter Number of Hours: ");
                    int numberOfHours = scanner.nextInt();
                    if (numberOfHours < 0 || rate < 0) {
                        System.out.println("Incorrect input. Number of Hours or Rate can't be less than 0");
                    } else {
                        Freelancer freelancer = new Freelancer(firstName, lastName, rate, numberOfHours);
                        addNewEmployee(freelancer);
                        isNegative = false;
                    }
                }
                break;
            }
            default: {
                System.out.println("Incorrect input");
                break;
            }
        }
    }

    public void sortEmployeesBySalaryDesc() {
        ArrayList<Employee> sortedList = employees;
        int left = 0; // left element
        int right = sortedList.size() - 1; // right element

        do {
            //left to right
            for (int i = left; i < right; i++) {
                if (sortedList.get(i).calculateSalary() < sortedList.get(i + 1).calculateSalary()) {
                    Employee temp = sortedList.get(i);
                    sortedList.add(i, sortedList.get(i + 1));
                    sortedList.remove(i + 1);
                    sortedList.remove(i + 1);
                    sortedList.add(i + 1, temp);
                }
            }
            right--; // decrease right
            //right to left
            for (int i = right; i > left; i--) {
                if (sortedList.get(i).calculateSalary() > sortedList.get(i - 1).calculateSalary()) {
                    Employee temp = sortedList.get(i);
                    sortedList.add(i - 1, sortedList.get(i));
                    sortedList.remove(i);
                    sortedList.remove(i);
                    sortedList.add(i, temp);
                }
            }
            left++; // increase left
        }
        while (left <= right);
        this.employees = sortedList;
        getEmployeesInfo();
    }

    public void sortEmployeesBySalaryAsc() {
        ArrayList<Employee> sortedList = employees;
        int left = 0; // left element
        int right = sortedList.size() - 1; // right element

        do {
            //left to right
            for (int i = left; i < right; i++) {
                if (sortedList.get(i).calculateSalary() > sortedList.get(i + 1).calculateSalary()) {
                    Employee temp = sortedList.get(i);
                    sortedList.add(i, sortedList.get(i + 1));
                    sortedList.remove(i + 1);
                    sortedList.remove(i + 1);
                    sortedList.add(i + 1, temp);
                }
            }
            right--; // decrease right
            //right to left
            for (int i = right; i > left; i--) {
                if (sortedList.get(i).calculateSalary() < sortedList.get(i - 1).calculateSalary()) {
                    Employee temp = sortedList.get(i - 1);
                    sortedList.add(i - 1, sortedList.get(i));
                    sortedList.remove(i);
                    sortedList.remove(i);
                    sortedList.add(i, temp);
                }
            }
            left++; // increase left
        }
        while (left <= right);
        this.employees = sortedList;
        getEmployeesInfo();
    }
}
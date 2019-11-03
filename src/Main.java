import Entities.Company;
import Services.ReadObjectFromFile;
import Services.Utils;
import Services.WriteObjectToFile;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Company company;
        try {
            company = (Company) ReadObjectFromFile.readFile("Company.ser");
        } catch (ClassCastException cce) {
            System.out.println(". New Company will be created");
            company = new Company();
        }
        ;

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        Utils.menuOptions();
        while (!exit) {
            System.out.println("Enter action (6 - to show available actions)");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0: {
                    WriteObjectToFile.createFile(company);
                    System.out.println("Shutting down...");
                    exit = true;
                    break;
                }
                case 1: {
                    company.registerNewEmployee();
                    break;
                }

                case 2: {
                    company.getEmployeesInfo();
                    break;
                }
                case 3: {
                    System.out.println("Salary Costs = " + company.calculateCosts());
                    System.out.println("Saving to Excel...");
                    Utils.createExcel(company.getEmployees(), "Files/Company_employee.xls");
                }
                case 4: {
                    company.sortEmployeesBySalaryDesc();
                    break;
                }
                case 5: {
                    company.sortEmployeesBySalaryAsc();
                    break;
                }
                case 6: {
                    Utils.menuOptions();
                    break;
                }
                default: {
                    System.out.println("Incorrect input");
                    Utils.menuOptions();
                }
            }

        }
    }
}

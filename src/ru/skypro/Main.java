package ru.skypro;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Ivanov Ivan Ivanovich", "1", 53_000);
        employees[1] = new Employee("Petrov Petr Petrovich", "1", 61_000);
        employees[2] = new Employee("Stepanov Stepan Stepanovich", "2", 75_000);
        employees[3] = new Employee("Sergeev Sergei Sergeevich", "2", 35_000);
        employees[4] = new Employee("Romanov Roman Romanovich", "3", 43_000);
        employees[5] = new Employee("Vasiliev Vasiliy Vasilievich", "3", 66_000);
        employees[6] = new Employee("Alexandrov Alexander Alexandrovich", "4", 18_000);
        employees[7] = new Employee("Mikhaylov Mikhail Mikhailovich", "4", 68_000);
        employees[8] = new Employee("Dmitriev Dmitrii Dmitrievich", "5", 28_000);
        employees[9] = new Employee("Vladimirov Vladimir Vladimirovich", "5", 33_000);

        System.out.println("Список сотрудников: " + Arrays.toString(employees));
        System.out.println("Общая месячная зарплата: " + getMonthSalaryAmount(employees));

        Employee employeeMin = getEmployeeWithMinSalary(employees);
        System.out.println("Работник с наименьшей зарплатой: " + employeeMin.getEmployeeSalary() + " руб."
                + " - "  + employeeMin.getEmployeeFullName()
                + ", из отдела - " + employeeMin.getEmployeeDepartment());

        Employee employeeMax = getEmployeeWithMaxSalary(employees);
        System.out.println("Работник с наибольшей зарплатой: " + employeeMax.getEmployeeSalary() + " руб."
                + " - "  + employeeMax.getEmployeeFullName()
                + ", из отдела - " + employeeMax.getEmployeeDepartment());

        System.out.println("Средняя зарплата: " + getAverageSalary(employees));

        System.out.println("Список всех ФИО:");
        printAllFullNames(employees);

    }

    public static int getMonthSalaryAmount(Employee[] employees) {
        int salaryAmount = 0;
        for (Employee employee : employees) {
            salaryAmount += employee.getEmployeeSalary();
        }
        return salaryAmount;
    }

    public static Employee getEmployeeWithMinSalary(Employee[] employees) {
        int minSalary = employees[0].getEmployeeSalary();
        int innerId = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeSalary() < minSalary) {
                minSalary = employees[i].getEmployeeSalary();
                innerId = i;
            }
        }
        return employees[innerId];
    }

    public static Employee getEmployeeWithMaxSalary(Employee[] employees) {
        int maxSalary = employees[0].getEmployeeSalary();
        int innerId = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeSalary() > maxSalary) {
                maxSalary = employees[i].getEmployeeSalary();
                innerId = i;
            }
        }
        return employees[innerId];
    }

    public static int getAverageSalary(Employee[] employees) {
        return getMonthSalaryAmount(employees) / employees.length;
    }

    public static void printAllFullNames(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeFullName());
        }
    }
}

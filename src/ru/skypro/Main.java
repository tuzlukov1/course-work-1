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

        System.out.println("Базовый уровень:");
        System.out.println("Список сотрудников: " + Arrays.toString(employees));
        System.out.println("Общая месячная зарплата: " + getMonthSalaryAmount(employees));

        Employee employeeMin = getEmployeeWithMinSalary(employees);
        System.out.println("Работник с наименьшей зарплатой: " + employeeMin.getEmployeeSalary() + " руб."
                + " - " + employeeMin.getEmployeeFullName()
                + ", из отдела - " + employeeMin.getEmployeeDepartment());

        Employee employeeMax = getEmployeeWithMaxSalary(employees);
        System.out.println("Работник с наибольшей зарплатой: " + employeeMax.getEmployeeSalary() + " руб."
                + " - " + employeeMax.getEmployeeFullName()
                + ", из отдела - " + employeeMax.getEmployeeDepartment());

        System.out.println("Средняя зарплата: " + getAverageSalary(employees));

        System.out.println("Список всех ФИО:");
        printAllFullNames(employees);
        System.out.println("_____");

        System.out.println("Продвинутый уровень:");
        int indexPercent = 10;
        indexSalaries(employees, indexPercent);
        System.out.println("Список сотрудников после индексации на " + indexPercent + " процента(ов): " + Arrays.toString(employees));

        String departmentMin = "4";
        Employee employeeMinFromDep = getEmployeeWithMinSalaryFromDepartment(employees, departmentMin);
        System.out.println("Работник с минимальной зарплатой с отдела " + departmentMin
                + " - " + employeeMinFromDep.getEmployeeFullName() + ", зарплата: " + employeeMinFromDep.getEmployeeSalary());

        String departmentMax = "3";
        Employee employeeMaxFromDep = getEmployeeWithMaxSalaryFromDepartment(employees, departmentMax);
        System.out.println("Работник с максимальной зарплатой с отдела " + departmentMax
                + " - " + employeeMaxFromDep.getEmployeeFullName() + ", зарплата: " + employeeMaxFromDep.getEmployeeSalary());

        String departmentSalaryAmount = "3";
        System.out.println("Сумма зарплат с отдела " + departmentSalaryAmount + " - "
                + getDepartmentMonthSalaryAmount(employees, departmentSalaryAmount));

        String departmentAverageSalary = "1";
        System.out.println("Средняя зарплата по отделу: " + departmentAverageSalary
                + " - " + getDepartmentAverageSalary(employees, departmentAverageSalary));

        int indexPercentForDepartment = 20;
        String departmentIndexSalary = "5";

        indexSalariesFromDepartment(employees, departmentIndexSalary, indexPercentForDepartment);
        System.out.println("Список сотрудников отдела " + departmentIndexSalary + " после индексации на " + indexPercentForDepartment + " процента(ов): ");
        printAllEmployeesFromDepartment(employees, departmentIndexSalary);

        int expectedSalaryBelow = 29_000;
        System.out.println("Список работников с зарплатой ниже: " + expectedSalaryBelow);
        printEmployeesWithSalaryBelowExpected(employees, expectedSalaryBelow);

        int expectedSalaryAbove = 50_000;
        System.out.println("Список работников с зарплатой выше или равной: " + expectedSalaryAbove);
        printEmployeesWithSalaryAboveExpected(employees, expectedSalaryAbove);
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

    public static void indexSalaries(Employee[] employees, int percent) {
        for (Employee employee : employees) {
            employee.setEmployeeSalary(employee.getEmployeeSalary() + employee.getEmployeeSalary() * percent / 100);
        }
    }

    public static Employee getEmployeeWithMinSalaryFromDepartment(Employee[] employees, String departmentNumber) {
        int minSalary = employees[0].getEmployeeSalary();
        int innerId = 0;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i].getEmployeeSalary() < minSalary) && (employees[i].getEmployeeDepartment().equals(departmentNumber))) {
                minSalary = employees[i].getEmployeeSalary();
                innerId = i;
            }
        }
        return employees[innerId];
    }

    public static Employee getEmployeeWithMaxSalaryFromDepartment(Employee[] employees, String departmentNumber) {
        int maxSalary = employees[0].getEmployeeSalary();
        int innerId = 0;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i].getEmployeeSalary() > maxSalary) && (employees[i].getEmployeeDepartment().equals(departmentNumber))) {
                maxSalary = employees[i].getEmployeeSalary();
                innerId = i;
            }
        }
        return employees[innerId];
    }

    public static int getDepartmentMonthSalaryAmount(Employee[] employees, String departmentNumber) {
        int salaryAmount = 0;
        for (Employee employee : employees) {
            if (employee.getEmployeeDepartment().equals(departmentNumber)) {
                salaryAmount += employee.getEmployeeSalary();
            }
        }
        return salaryAmount;
    }

    public static int getDepartmentSize(Employee[] employees, String departmentNumber) {
        int departmentSize = 0;
        for (Employee employee : employees) {
            if (employee.getEmployeeDepartment().equals(departmentNumber)) departmentSize++;
        }
        return departmentSize;
    }

    public static int getDepartmentAverageSalary(Employee[] employees, String departmentNumber) {
        return getDepartmentMonthSalaryAmount(employees, departmentNumber) / getDepartmentSize(employees, departmentNumber);
    }

    public static void indexSalariesFromDepartment(Employee[] employees, String department, int percent) {
        for (Employee employee : employees) {
            if (employee.getEmployeeDepartment().equals(department)) {
                employee.setEmployeeSalary(employee.getEmployeeSalary() + employee.getEmployeeSalary() * percent / 100);
            }
        }
    }

    public static void printAllEmployeesFromDepartment(Employee[] employees, String department) {
        for (Employee employee : employees) {
            if (employee.getEmployeeDepartment().equals(department)) {
                System.out.println("ФИО:" + employee.getEmployeeFullName() + ", зарплата: " + employee.getEmployeeSalary());
            }
        }
    }

    public static void printEmployeesWithSalaryBelowExpected(Employee[] employees, int expectedSalary) {
        for (Employee employee : employees) {
            if (employee.getEmployeeSalary() < expectedSalary) {
                System.out.println("id:" + employee.getId() + " ФИО:" + employee.getEmployeeFullName() + ", зарплата: " + employee.getEmployeeSalary());
            }
        }
    }

    public static void printEmployeesWithSalaryAboveExpected(Employee[] employees, int expectedSalary) {
        for (Employee employee : employees) {
            if (employee.getEmployeeSalary() >= expectedSalary) {
                System.out.println("id:" + employee.getId() + " ФИО:" + employee.getEmployeeFullName() + ", зарплата: " + employee.getEmployeeSalary());
            }
        }
    }
}

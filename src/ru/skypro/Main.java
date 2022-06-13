package ru.skypro;

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        System.out.println("Базовый уровень:");
        System.out.println("Список сотрудников: ");
        employeeBook.printEmployeesList();

        System.out.println("Общая месячная зарплата: " + employeeBook.getMonthSalaryAmount());

        Employee employeeMin = employeeBook.getEmployeeWithMinSalary();
        System.out.println("Работник с наименьшей зарплатой: " + employeeMin.getEmployeeSalary() + " руб."
                + " - " + employeeMin.getEmployeeFullName()
                + ", из отдела - " + employeeMin.getEmployeeDepartment());

        Employee employeeMax = employeeBook.getEmployeeWithMaxSalary();
        System.out.println("Работник с наибольшей зарплатой: " + employeeMax.getEmployeeSalary() + " руб."
                + " - " + employeeMax.getEmployeeFullName()
                + ", из отдела - " + employeeMax.getEmployeeDepartment());

        System.out.println("Средняя зарплата: " + employeeBook.getAverageSalary());

        System.out.println("Список всех ФИО:");
        employeeBook.printAllFullNames();
        System.out.println("_____");

        System.out.println("Продвинутый уровень:");
        int indexPercent = 10;
        employeeBook.indexSalaries(indexPercent);
        System.out.println("Список сотрудников после индексации на " + indexPercent + " процента(ов): ");
        employeeBook.printEmployeesList();

        String departmentMin = "4";
        Employee employeeMinFromDep = employeeBook.getEmployeeWithMinSalaryFromDepartment(departmentMin);
        System.out.println("Работник с минимальной зарплатой с отдела " + departmentMin
                + " - " + employeeMinFromDep.getEmployeeFullName() + ", зарплата: " + employeeMinFromDep.getEmployeeSalary());

        String departmentMax = "3";
        Employee employeeMaxFromDep = employeeBook.getEmployeeWithMaxSalaryFromDepartment(departmentMax);
        System.out.println("Работник с максимальной зарплатой с отдела " + departmentMax
                + " - " + employeeMaxFromDep.getEmployeeFullName() + ", зарплата: " + employeeMaxFromDep.getEmployeeSalary());

        String departmentSalaryAmount = "3";
        System.out.println("Сумма зарплат с отдела " + departmentSalaryAmount + " - "
                + employeeBook.getDepartmentMonthSalaryAmount(departmentSalaryAmount));

        String departmentAverageSalary = "1";
        System.out.println("Средняя зарплата по отделу: " + departmentAverageSalary
                + " - " + employeeBook.getDepartmentAverageSalary(departmentAverageSalary));

        int indexPercentForDepartment = 20;
        String departmentIndexSalary = "5";

        employeeBook.indexSalariesFromDepartment(departmentIndexSalary, indexPercentForDepartment);
        System.out.println("Список сотрудников отдела " + departmentIndexSalary + " после индексации на " + indexPercentForDepartment + " процента(ов): ");
        employeeBook.printAllEmployeesFromDepartment(departmentIndexSalary);

        int expectedSalaryBelow = 29_000;
        System.out.println("Список работников с зарплатой ниже: " + expectedSalaryBelow);
        employeeBook.printEmployeesWithSalaryBelowExpected(expectedSalaryBelow);

        int expectedSalaryAbove = 50_000;
        System.out.println("Список работников с зарплатой выше или равной: " + expectedSalaryAbove);
        employeeBook.printEmployeesWithSalaryAboveExpected(expectedSalaryAbove);
        System.out.println("_____");

        System.out.println("Экстра уровень:");
        employeeBook.deleteEmployee("Petrov Petr Petrovich");
        System.out.println("Список работников после удаления:");
        employeeBook.printEmployeesList();

        System.out.println("Список работников после добавления:");
        employeeBook.createNewEmployee("Andreev Andrey Andreevich", "1", 15_000);
        employeeBook.createNewEmployee("Kirillov Kirill Kirillovich", "1", 22_000);
        employeeBook.printEmployeesList();

        System.out.println("Список работников после редактирования:");
        employeeBook.editEmployee("Andreev Andrey Andreevich", 25_000);
        employeeBook.editEmployee("Kirillov Kirill Kirillovich", "2");
        employeeBook.printEmployeesList();

    }
}

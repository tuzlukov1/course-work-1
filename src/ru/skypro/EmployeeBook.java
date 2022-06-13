package ru.skypro;

import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    Map<String, Employee> employees = new HashMap<>(Map.of(
            "Ivanov Ivan Ivanovich", new Employee("Ivanov Ivan Ivanovich", "1", 53_000),
            "Petrov Petr Petrovich", new Employee("Petrov Petr Petrovich", "1", 61_000),
            "Stepanov Stepan Stepanovich", new Employee("Stepanov Stepan Stepanovich", "2", 75_000),
            "Sergeev Sergei Sergeevich", new Employee("Sergeev Sergei Sergeevich", "2", 35_000),
            "Romanov Roman Romanovich", new Employee("Romanov Roman Romanovich", "3", 43_000),
            "Vasiliev Vasiliy Vasilievich", new Employee("Vasiliev Vasiliy Vasilievich", "3", 66_000),
            "Alexandrov Alexander Alexandrovich", new Employee("Alexandrov Alexander Alexandrovich", "4", 18_000),
            "Mikhaylov Mikhail Mikhailovich", new Employee("Mikhaylov Mikhail Mikhailovich", "4", 68_000),
            "Dmitriev Dmitrii Dmitrievich", new Employee("Dmitriev Dmitrii Dmitrievich", "5", 28_000),
            "Vladimirov Vladimir Vladimirovich", new Employee("Vladimirov Vladimir Vladimirovich", "5", 33_000)
    ));

    public void createNewEmployee(String fullName, String department, int salary) {
        Employee employee = new Employee(fullName, department, salary);
        employees.put(fullName, employee);
    }

    public void deleteEmployee(String fullName) {
        employees.remove(fullName);
    }

    public void editEmployee(String fullName, int salary) {
        Employee employee = employees.get(fullName);
        employee.setEmployeeSalary(salary);
    }

    public void editEmployee(String fullName, String department) {
        Employee employee = employees.get(fullName);
        if (department.length() == 1) {
            employee.setEmployeeDepartment(department);

        } else throw new IllegalArgumentException("Департамент должен быть числом от 1 до 5 в формате строки");
    }


    public void printEmployeesList() {
        System.out.println(employees);
    }

    public int getMonthSalaryAmount() {
        int salaryAmount = 0;
        for (Employee employee : employees.values()) {
            salaryAmount += employee.getEmployeeSalary();
        }
        return salaryAmount;
    }

    public Employee getEmployeeWithMinSalary() {
        int minSalary = employees.get("Ivanov Ivan Ivanovich").getEmployeeSalary();
        String key = "";
        for (Employee employee : employees.values()) {
            if (employee.getEmployeeSalary() < minSalary) {
                minSalary = employee.getEmployeeSalary();
                key = employee.getEmployeeFullName();
            }
        }
        return employees.get(key);
    }

    public Employee getEmployeeWithMaxSalary() {
        int maxSalary = employees.get("Ivanov Ivan Ivanovich").getEmployeeSalary();
        String key = "";
        for (Employee employee : employees.values()) {
            if (employee.getEmployeeSalary() > maxSalary) {
                maxSalary = employee.getEmployeeSalary();
                key = employee.getEmployeeFullName();
            }
        }
        return employees.get(key);
    }

    public int getAverageSalary() {
        return getMonthSalaryAmount() / employees.size();
    }

    public void printAllFullNames() {
        for (Employee employee : employees.values()) {
            System.out.println(employee.getEmployeeFullName());
        }
    }

    public void indexSalaries(int percent) {
        for (Employee employee : employees.values()) {
            employee.setEmployeeSalary(employee.getEmployeeSalary() + employee.getEmployeeSalary() * percent / 100);
        }
    }

    public Employee getEmployeeWithMinSalaryFromDepartment(String departmentNumber) {
        int minSalary = employees.get("Ivanov Ivan Ivanovich").getEmployeeSalary();
        String key = "";
        for (Employee employee : employees.values()) {
            if ((employee.getEmployeeSalary() < minSalary) && (employee.getEmployeeDepartment().equals(departmentNumber))) {
                minSalary = employee.getEmployeeSalary();
                key = employee.getEmployeeFullName();
            }
        }
        return employees.get(key);
    }

    public Employee getEmployeeWithMaxSalaryFromDepartment(String departmentNumber) {
        int maxSalary = employees.get("Ivanov Ivan Ivanovich").getEmployeeSalary();
        String key = "";
        for (Employee employee : employees.values()) {
            if ((employee.getEmployeeSalary() > maxSalary) && (employee.getEmployeeDepartment().equals(departmentNumber))) {
                maxSalary = employee.getEmployeeSalary();
                key = employee.getEmployeeFullName();
            }
        }
        return employees.get(key);
    }

    public int getDepartmentMonthSalaryAmount(String departmentNumber) {
        int salaryAmount = 0;
        for (Employee employee : employees.values()) {
            if (employee.getEmployeeDepartment().equals(departmentNumber)) {
                salaryAmount += employee.getEmployeeSalary();
            }
        }
        return salaryAmount;
    }

    public int getDepartmentSize(String departmentNumber) {
        int departmentSize = 0;
        for (Employee employee : employees.values()) {
            if (employee.getEmployeeDepartment().equals(departmentNumber)) departmentSize++;
        }
        return departmentSize;
    }

    public int getDepartmentAverageSalary(String departmentNumber) {
        return getDepartmentMonthSalaryAmount(departmentNumber) / getDepartmentSize(departmentNumber);
    }

    public void indexSalariesFromDepartment(String department, int percent) {
        for (Employee employee : employees.values()) {
            if (employee.getEmployeeDepartment().equals(department)) {
                employee.setEmployeeSalary(employee.getEmployeeSalary() + employee.getEmployeeSalary() * percent / 100);
            }
        }
    }

    public void printAllEmployeesFromDepartment(String department) {
        for (Employee employee : employees.values()) {
            if (employee.getEmployeeDepartment().equals(department)) {
                System.out.println("ФИО:" + employee.getEmployeeFullName() + ", зарплата: " + employee.getEmployeeSalary());
            }
        }
    }

    public void printEmployeesWithSalaryBelowExpected(int expectedSalary) {
        for (Employee employee : employees.values()) {
            if (employee.getEmployeeSalary() < expectedSalary) {
                System.out.println("id:" + employee.getId() + " ФИО:" + employee.getEmployeeFullName() + ", зарплата: " + employee.getEmployeeSalary());
            }
        }
    }

    public void printEmployeesWithSalaryAboveExpected(int expectedSalary) {
        for (Employee employee : employees.values()) {
            if (employee.getEmployeeSalary() >= expectedSalary) {
                System.out.println("id:" + employee.getId() + " ФИО:" + employee.getEmployeeFullName() + ", зарплата: " + employee.getEmployeeSalary());
            }
        }
    }
}


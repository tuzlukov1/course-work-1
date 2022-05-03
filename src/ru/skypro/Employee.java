package ru.skypro;

public class Employee {

    private String employeeFullName;
    private String employeeDepartment;
    private int employeeSalary;
    private static int id;

    public Employee(String employeeFullName, String employeeDepartment, int employeeSalary) {
        id++;
        this.employeeFullName = employeeFullName;
        this.employeeDepartment = employeeDepartment;
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public static int getId() {
        return id;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeFullName='" + employeeFullName + '\'' +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}

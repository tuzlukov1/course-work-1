package ru.skypro;

public class Employee {

    private String employeeFullName;
    private String employeeDepartment;
    private int employeeSalary;
    private int id;

    private static int counter;

    public Employee(String employeeFullName, String employeeDepartment, int employeeSalary) {
        this.employeeFullName = employeeFullName;
        this.employeeDepartment = employeeDepartment;
        this.employeeSalary = employeeSalary;
        this.id = counter++;
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

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

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
        employeeBook.deleteEmployee(2);
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

        employeeBook.printAllEmployeesFromAllDepartments();

    }

    private static class EmployeeBook {

        Employee[] employees = new Employee[10];

        public EmployeeBook() {
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
        }

        public void createNewEmployee(String fullName, String department, int salary) {
            for (Employee employee : employees) {
                if (employee.getEmployeeFullName().equals("") && employee.getEmployeeDepartment().equals("") && employee.getEmployeeSalary() == 0) {
                    employee.setEmployeeFullName(fullName);
                    employee.setEmployeeDepartment(department);
                    employee.setEmployeeSalary(salary);
                    break;
                }
            }
        }

        public void deleteEmployee(String fullName) {
            for (Employee employee : employees) {
                if (employee.getEmployeeFullName().equals(fullName)) {
                    employee.setEmployeeFullName("");
                    employee.setEmployeeDepartment("");
                    employee.setEmployeeSalary(0);
                }
            }
        }

        public void deleteEmployee(int id) {
            for (Employee employee : employees) {
                if (employee.getId() == id) {
                    employee.setEmployeeFullName("");
                    employee.setEmployeeDepartment("");
                    employee.setEmployeeSalary(0);
                }
            }
        }

        public void editEmployee(String fullName, int salary) {
            for (Employee employee : employees) {
                if (salary > 0) {
                    if (employee.getEmployeeFullName().equals(fullName)) {
                        employee.setEmployeeSalary(salary);
                    }
                } else throw new IllegalArgumentException("Зарплата должна быть больше нуля");
            }
        }

        public void editEmployee(String fullName, String department) {
            for (Employee employee : employees) {
                if (department.length() == 1) {
                    if (employee.getEmployeeFullName().equals(fullName)) {
                        employee.setEmployeeDepartment(department);
                    }
                } else throw new IllegalArgumentException("Департамент должен быть числом от 1 до 5 в формате строки");
            }
        }

        public void printEmployeesList() {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        }

        public int getMonthSalaryAmount() {
            int salaryAmount = 0;
            for (Employee employee : employees) {
                salaryAmount += employee.getEmployeeSalary();
            }
            return salaryAmount;
        }

        public Employee getEmployeeWithMinSalary() {
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

        public Employee getEmployeeWithMaxSalary() {
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

        public int getAverageSalary() {
            return getMonthSalaryAmount() / employees.length;
        }

        public void printAllFullNames() {
            for (Employee employee : employees) {
                System.out.println(employee.getEmployeeFullName());
            }
        }

        public void indexSalaries(int percent) {
            for (Employee employee : employees) {
                employee.setEmployeeSalary(employee.getEmployeeSalary() + employee.getEmployeeSalary() * percent / 100);
            }
        }

        public Employee getEmployeeWithMinSalaryFromDepartment(String departmentNumber) {
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

        public Employee getEmployeeWithMaxSalaryFromDepartment(String departmentNumber) {
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

        public int getDepartmentMonthSalaryAmount(String departmentNumber) {
            int salaryAmount = 0;
            for (Employee employee : employees) {
                if (employee.getEmployeeDepartment().equals(departmentNumber)) {
                    salaryAmount += employee.getEmployeeSalary();
                }
            }
            return salaryAmount;
        }

        public int getDepartmentSize(String departmentNumber) {
            int departmentSize = 0;
            for (Employee employee : employees) {
                if (employee.getEmployeeDepartment().equals(departmentNumber)) departmentSize++;
            }
            return departmentSize;
        }

        public int getDepartmentAverageSalary(String departmentNumber) {
            return getDepartmentMonthSalaryAmount(departmentNumber) / getDepartmentSize(departmentNumber);
        }

        public void indexSalariesFromDepartment(String department, int percent) {
            for (Employee employee : employees) {
                if (employee.getEmployeeDepartment().equals(department)) {
                    employee.setEmployeeSalary(employee.getEmployeeSalary() + employee.getEmployeeSalary() * percent / 100);
                }
            }
        }

        public void printAllEmployeesFromDepartment(String department) {
            for (Employee employee : employees) {
                if (employee.getEmployeeDepartment().equals(department)) {
                    System.out.println("ФИО:" + employee.getEmployeeFullName() + ", зарплата: " + employee.getEmployeeSalary());
                }
            }
        }

        public void printAllEmployeesFromAllDepartments() {
            String var = "";
            for (Employee employee : employees) {
                if (!var.equals(employee.getEmployeeDepartment())) {
                    System.out.println("\nРаботники отдела " + employee.getEmployeeDepartment() + ":");
                    var = employee.getEmployeeDepartment();
                }
                System.out.println(employee.getEmployeeFullName());
            }
        }

        public void printEmployeesWithSalaryBelowExpected(int expectedSalary) {
            for (Employee employee : employees) {
                if (employee.getEmployeeSalary() < expectedSalary) {
                    System.out.println("id:" + employee.getId() + " ФИО:" + employee.getEmployeeFullName() + ", зарплата: " + employee.getEmployeeSalary());
                }
            }
        }

        public void printEmployeesWithSalaryAboveExpected(int expectedSalary) {
            for (Employee employee : employees) {
                if (employee.getEmployeeSalary() >= expectedSalary) {
                    System.out.println("id:" + employee.getId() + " ФИО:" + employee.getEmployeeFullName() + ", зарплата: " + employee.getEmployeeSalary());
                }
            }
        }
    }
}

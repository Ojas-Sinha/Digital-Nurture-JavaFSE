//Exercise 4: Employee Management System

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return employeeId + " " + name + " " + position + " Rs." + salary;
    }
}

public class EmployeeManagementSystem {

    Employee[] employees = new Employee[10];
    int size = 0;

    void addEmployee(Employee emp) {

        if(size < employees.length) {
            employees[size++] = emp;
            System.out.println("Employee Added");
        }
        else
            System.out.println("Array Full");
    }

    Employee searchEmployee(int id) {

        for(int i = 0; i < size; i++) {

            if(employees[i].employeeId == id)
                return employees[i];
        }

        return null;
    }

    void traverseEmployees() {

        for(int i = 0; i < size; i++)
            System.out.println(employees[i]);

        System.out.println();
    }

    void deleteEmployee(int id) {

        int index = -1;

        for(int i = 0; i < size; i++) {

            if(employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            System.out.println("Employee Not Found");
            return;
        }

        for(int i = index; i < size - 1; i++)
            employees[i] = employees[i + 1];

        employees[size - 1] = null;
        size--;

        System.out.println("Employee Deleted");
    }

    public static void main(String[] args) {

        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        ems.addEmployee(new Employee(101, "Rahul", "Manager", 60000));
        ems.addEmployee(new Employee(102, "Amit", "Developer", 50000));
        ems.addEmployee(new Employee(103, "Priya", "Tester", 45000));

        System.out.println("Employees:");
        ems.traverseEmployees();

        System.out.println("Search Employee:");
        System.out.println(ems.searchEmployee(102));

        ems.deleteEmployee(102);

        System.out.println("\nAfter Deletion:");
        ems.traverseEmployees();
    }
}
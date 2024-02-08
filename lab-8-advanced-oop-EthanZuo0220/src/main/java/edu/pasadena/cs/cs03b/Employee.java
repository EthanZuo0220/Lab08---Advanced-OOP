package edu.pasadena.cs.cs03b; // Defines the package in which this class resides

// Abstract class Employee
public abstract class Employee extends Person { // Employee class extends from Person class

    protected String employeeId; // Protected variable to store the employee's ID
    protected Employer employer = null; // Protected variable to store the employer of the employee
    protected Employee Supervisor = null; // Protected variable to store the supervisor of the employee

    // Constructor with only name parameter
    public Employee(String name) {
        super(name); // Calls the constructor of the superclass Person
    }

    // Constructor with name and employeeId parameters
    public Employee(String name, String employeeId) {
        super(name); // Calls the constructor of the superclass Person
        this.employeeId = employeeId; // Sets the employee's ID
    }

    // Constructor with name, employeeId, and Supervisor parameters
    public Employee(String name, String employeeId, Employee Supervisor) {
        super(name); // Calls the constructor of the superclass Person
        this.employeeId = employeeId; // Sets the employee's ID
        this.Supervisor = Supervisor; // Sets the supervisor of the employee
    }

    // Constructor with name, employeeId, and employer parameters
    public Employee(String name, String employeeId, Employer employer) {
        super(name); // Calls the constructor of the superclass Person
        this.employeeId = employeeId; // Sets the employee's ID
        this.employer = employer; // Sets the employer of the employee
    }

    // Setter method for the employeeId variable
    public void setId(String employeeId) {
        this.employeeId = employeeId;
    }

    // Getter method for the employeeId variable
    public String getId() {
        return employeeId;
    }

    // Setter method for the Supervisor variable
    public void setSupervisor(Employee employee) {
        this.Supervisor = employee;
    }

    // Getter method for the Supervisor variable
    public Employee getSupervisor() {
        return Supervisor;
    }

    // Method to display information about the Employee
    public void displayInfo() {
        super.displayInfo(); // Calls the displayInfo method of the superclass Person
        System.out.print("Employee ID: " + employeeId + ". \nSupervisor: "); // Prints the employee's ID and the name of the supervisor
        if (employer != null) { // Checks if the employer is not null
            System.out.print(employer.getName() + ", "); // Prints the name of the employer
        } else if (Supervisor != null) { // Checks if the supervisor is not null
            System.out.print(Supervisor.getName() + ", "); // Prints the name of the supervisor
        } else {
            System.out.print("None, "); // Prints "None," if both employer and supervisor are null
        }
    }
}

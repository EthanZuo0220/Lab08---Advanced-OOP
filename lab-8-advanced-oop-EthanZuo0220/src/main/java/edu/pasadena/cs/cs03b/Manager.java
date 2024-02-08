package edu.pasadena.cs.cs03b; // Defines the package in which this class resides

// Class Manager
public class Manager extends Employee { // Manager class extends from Employee class

    Employee[] employees = new Employee[5]; // Array to store Employee objects, initially size is 5

    private String department; // Private variable to store the department of the Manager
    private int size = 0; // Variable to keep track of the current number of employees

    // Constructor with only name parameter
    public Manager(String name) {
        super(name); // Calls the constructor of the superclass Employee
    }

    // Constructor with name, employeeId, and department parameters
    public Manager(String name, String employeeId, String department) {
        super(name, employeeId); // Calls the constructor of the superclass Employee
        this.department = department; // Sets the department of the Manager
    }

    // Constructor with name, employeeId, department, and employer parameters
    public Manager(String name, String employeeId, String department, Employer employer) {
        super(name, employeeId, employer); // Calls the constructor of the superclass Employee
        this.department = department; // Sets the department of the Manager
    }

    // Constructor with name, employeeId, department, employer, and Employee parameters
    public Manager(String name, String employeeId, String department, Employer employer, Employee Employee) {
        super(name, employeeId, employer); // Calls the constructor of the superclass Employee
        this.department = department; // Sets the department of the Manager
        addEmployee(Employee); // Adds an Employee to the Manager's list of employees
    }

    // Method to add an Employee to the Manager's list of employees
    public void addEmployee(Employee employee) {
        // Checks if the array has enough space to store a new element
        if (size == employees.length) {
            increaseCapacity(); // Increases the capacity of the array
        }
        employees[size++] = employee; // Adds the Employee to the array and increments the size
    }

    // Method to increase the capacity of the employees array
    private void increaseCapacity() {
        int newCapacity = employees.length * 2; // Doubles the current capacity
        Employee[] newEmployees = new Employee[newCapacity]; // Creates a new array with the increased capacity
        System.arraycopy(employees, 0, newEmployees, 0, employees.length); // Copies the old array into the new array
        employees = newEmployees; // Assigns the new array to the employees variable
    }

    // Setter method for the department variable
    public void setDepartment(String department) {
        this.department = department;
    }

    // Getter method for the department variable
    public String getDepartment() {
        return department;
    }

    // Setter method for the employer variable
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    // Getter method for the employer variable
    public Employer getEmployer() {
        return employer;
    }

    // Method to add an Employee and set it to the Manager
    public void setEmployee(Employee employee) {
        addEmployee(employee);
    }

    // Getter method for the employees array
    public Employee[] getEmployee() {
        return employees;
    }

    // Method to get the number of Employees under the Manager
    public int getNumberOfEmployee() {
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                count++; // Increments the count if the Employee at the index is not null
            }
        }
        return count;
    }

    // Method to display information about the Manager
    public void displayManagerInfo() {
        super.displayInfo(); // Calls the displayInfo method of the superclass Employee
        System.out.println("Department: " + this.department); // Prints the department of the Manager
    }

    public void displayInfo() {
        System.out.println("\n--------------------------------------------------------------------\n"); // Prints a separator line for readability
    
        System.out.println(getDepartment() + " ：\n"); // Prints the department name
    
        System.out.println("Manager Info: \n"); // Prints a header for the manager's information
    
        super.displayInfo(); // Calls the displayInfo method of the superclass Employee to print the manager's name and ID
    
        System.out.println("has " + getNumberOfEmployee() + " people.\nDepartment: " + department + ".\n"); // Prints the number of employees and the department name
    
        boolean hasStaff = false; // Flag to check if there are any staff employees
        boolean hasContractors = false; // Flag to check if there are any contractor employees
    
        // Prints information about Staff Employees
        System.out.println("Department Staff Employees: \n");
        for (int i = 0; i < employees.length; i++) { // Iterates over the employees array
            if (employees[i] != null && employees[i] instanceof Staff) { // Checks if the employee is not null and is an instance of Staff
                hasStaff = true; // Sets the flag to true
                System.out.print(i + 1 + ". "); // Prints the index of the employee
                employees[i].displayInfo(); // Calls the displayInfo method of the Employee to print their information
            }
        }
        if (!hasStaff) { // If the flag is still false, it means there were no staff employees
            System.out.println("None."); // Prints "None."
        }
    
        // Prints information about Contractor Employees
        System.out.println("\nDepartment Contractors: \n");
        for (int i = 0; i < employees.length; i++) { // Iterates over the employees array
            if (employees[i] != null && employees[i] instanceof Contractor) { // Checks if the employee is not null and is an instance of Contractor
                hasContractors = true; // Sets the flag to true
                System.out.print(i + 1 + ". "); // Prints the index of the employee
                employees[i].displayInfo(); // Calls the displayInfo method of the Employee to print their information
            }
        }
        if (!hasContractors) { // If the flag is still false, it means there were no contractor employees
            System.out.println("None."); // Prints "None."
        }
    
        System.out.println("\n--------------------------------------------------------------------"); // Prints a separator line for readability
    }
    

}
package edu.pasadena.cs.cs03b; // Defines the package name, organizing this class within the project structure.

// The Employer class extends the Person class, inheriting its properties and methods.
public class Employer extends Person {
    // Array to store Employee objects. Initially set to hold 5 employees.
    Employee[] employees = new Employee[5];
    // Variable to track the current number of employees. Initialized to 0.
    private int size = 0;

    // Constructor that takes the employer's name. Calls the superclass (Person) constructor to set the name.
    public Employer(String name) {
        super(name); // Passes the employer's name to the Person class constructor.
    }

    // Overloaded constructor that also takes an Employee object to add to the Employer's employee list.
    public Employer(String name, Employee employees) {
        super(name); // Sets the employer's name using the Person class constructor.
        addEmployee(employees); // Adds the provided Employee object to the employees array.
    }

    // Method to add an Employee object to the employees array.
    public void addEmployee(Employee employee) {
        if (size == employees.length) { // Check if the array is full.
            increaseCapacity(); // Double the array size if it's full.
        }
        employees[size++] = employee; // Add the new employee and increment the size counter.
    }

    // Method to remove an Employee by their name. Iterates through the employees array to find and remove the matching employee.
    public void removeEmployeeByName(String employeeName) {
        for (int i = 0; i < size; i++) { // Loop through the array of employees.
            if (employees[i] != null && employees[i].getName().equals(employeeName)) { // Check if the current employee matches the given name.
                for (int j = i; j < size - 1; j++) { // Shift the rest of the employees one position up in the array.
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null; // Set the last element to null after shifting.
                size--; // Decrement the size counter.
                break; // Exit the loop after removing the employee.
            }
        }
    }

    // Private method to increase the capacity of the employees array when it's full.
    private void increaseCapacity() {
        int newCapacity = employees.length * 2; // Double the current capacity.
        Employee[] newEmployees = new Employee[newCapacity]; // Create a new array with the increased capacity.
        System.arraycopy(employees, 0, newEmployees, 0, employees.length); // Copy the existing employees into the new array.
        employees = newEmployees; // Assign the new array to the employees variable.
    }

    // Method to count the number of Managers in the employees array.
    int NumberOfManager(Employee[] employees) {
        int count = 0; // Counter for the number of Managers.
        for (int i = 0; i < employees.length; i++) { // Iterate through the employees array.
            if (employees[i] != null && employees[i] instanceof Manager) { // Check if the current employee is a Manager.
                count++; // Increment the counter if a Manager is found.
            } else {
                break; // Exit the loop if a non-Manager is encountered.
            }
        }
        return count; // Return the total count of Managers.
    }

    // Method to count the number of Staff in the employees array.
    int NumberOfStaff(Employee[] employees) {
        int count = 0; // Counter for the number of Staff members.
        for (int i = 0; i < employees.length; i++) { // Iterate through the employees array.
            if (employees[i] != null && employees[i] instanceof Staff) { // Check if the current employee is a Staff member.
                count++; // Increment the counter if a Staff member is found.
            }
        }
        return count; // Return the total count of Staff members.
    }

    // Method to count the number of Contractors in the employees array.
    int NumberOfContractor(Employee[] employees) {
        int count = 0; // Counter for the number of Contractors.
        for (int i = 0; i < employees.length; i++) { // Iterate through the employees array.
            if (employees[i] != null && employees[i] instanceof Contractor) { // Check if the current employee is a Contractor.
                count++; // Increment the counter if a Contractor is found.
            }
        }
        return count; // Return the total count of Contractors.
    }

    // Method to display information about the employer.
    public void displayEmployerInfo() {
        System.out.println("Employer Name: " + this.getName()); // Print the employer's name.
        // Additional employer details can be added here.
    }

    // Overridden displayInfo method to include detailed information about the employer and their employees.
    public void displayInfo() {
        System.out.println(); // Print a newline for formatting.
        super.displayInfo(); // Call the displayInfo method from the Person superclass to print the employer's name.
        // Print the number of Managers, Staff, and Contractors.
        System.out.println("\nNumber of Managers: " + NumberOfManager(employees));
        System.out.println("Number of Employees: " + (NumberOfStaff(employees) + NumberOfContractor(employees)));
    }
}

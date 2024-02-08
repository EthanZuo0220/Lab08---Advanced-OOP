package edu.pasadena.cs.cs03b; // Defines the package this class is part of for organization and avoiding naming conflicts.

import java.util.Random; // Imports the Random class for generating random values.

// The Contractor class extends the Employee class and implements the Freelancer interface.
// This means it inherits the properties and methods of an Employee and must implement the methods defined in Freelancer.
public class Contractor extends Employee implements Freelancer {
    private String project; // A private String variable to hold the name or details of the project assigned to the contractor.

    // Constructor with only the 'name' parameter. Calls the superclass (Employee) constructor to set the name.
    public Contractor(String name) {
        super(name); // 'super' refers to the superclass, Employee, and its constructor.
    }

    // Constructor with 'name' and 'employeeId' parameters. Also calls the superclass constructor to set these values.
    public Contractor(String name, String employeeId) {
        super(name, employeeId); // Passes 'name' and 'employeeId' to the Employee constructor.
    }

    // Constructor with 'name', 'employeeId', and 'project' parameters. Sets 'name' and 'employeeId' using the Employee constructor and 'project' using the local variable.
    public Contractor(String name, String employeeId, String project) {
        super(name, employeeId); // Initialize 'name' and 'employeeId' through the Employee constructor.
        this.project = project; // Sets the 'project' variable to the value passed to the constructor.
    }

    // Constructor with 'name', 'employeeId', 'project', and 'Supervisor'. This not only initializes 'name', 'employeeId', and 'project' but also sets the 'Supervisor' through the Employee constructor.
    public Contractor(String name, String employeeId, String project, Employee Supervisor) {
        super(name, employeeId, Supervisor); // Initialize 'name', 'employeeId', and 'Supervisor' through the Employee constructor.
        this.project = project; // Sets the 'project' variable to the value passed to the constructor.
    }

    // Setter method for 'project'. Allows the project for this contractor to be set or changed after instantiation.
    public void setContractPeriod(String project) {
        this.project = project; // Assigns the new project value to the 'project' variable.
    }

    // Getter method for 'project'. Allows other classes to retrieve the value of the project assigned to this contractor.
    public String getContractPeriod() {
        return project; // Returns the current value of the 'project' variable.
    }

    // Implements the 'AcceptProject' method from the Freelancer interface. This method randomly decides if the contractor accepts or declines a project.
    public Boolean AcceptProject() {
        Random random = new Random(); // Creates a Random object for generating random boolean values.
        boolean decision = random.nextBoolean(); // Randomly generates and assigns true or false to 'decision'.

        // Conditional statement to print the decision outcome.
        if (decision) {
            System.out.println("Contractor " + getName() + " accepts the project.\n"); // If 'decision' is true, print acceptance message.
        } else {
            System.out.println("Contractor " + getName() + " declines the project.\n"); // If 'decision' is false, print decline message.
        }

        return decision; // Returns the randomly generated decision (true or false).
    }

    // Overridden 'displayInfo' method from the Employee class to include project information specific to the Contractor.
    public void displayInfo() {
        super.displayInfo(); // Calls 'displayInfo' from the Employee class to display basic employee information.
        System.out.println("Contracting project: " + project + "."); // Adds additional information about the contracting project.
    }
}

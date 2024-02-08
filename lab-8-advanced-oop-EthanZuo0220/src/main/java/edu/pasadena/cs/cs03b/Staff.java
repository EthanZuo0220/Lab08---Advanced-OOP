package edu.pasadena.cs.cs03b; // Defines the package this class belongs to, which helps in organizing and managing the code.

// Definition of the Staff class, which extends the Employee class, inheriting its properties and methods.
public class Staff extends Employee {
    private String ability; // A private string variable to hold the special ability or skill of the Staff member.

    // Constructor with only the 'name' parameter, utilizing the constructor of the superclass (Employee) to set the name.
    public Staff(String name) {
        super(name); // Calls the constructor of the superclass (Employee) with the 'name' parameter.
    }

    // Constructor with 'name', 'employeeId', and 'ability' parameters. Sets 'name' and 'employeeId' using the superclass constructor and 'ability' using the local variable.
    public Staff(String name, String employeeId, String ability) {
        super(name, employeeId); // Calls the superclass constructor to initialize 'name' and 'employeeId'.
        this.ability = ability; // Sets the 'ability' variable to the value passed to the constructor.
    }

    // Constructor with 'name', 'employeeId', 'ability', and 'Supervisor', initializing all properties, including assigning a supervisor to the Staff.
    public Staff(String name, String employeeId, String ability, Employee Supervisor) {
        super(name, employeeId, Supervisor); // Calls the superclass constructor to initialize 'name', 'employeeId', and 'Supervisor'.
        this.ability = ability; // Sets the 'ability' variable to the value passed to the constructor.
    }

    // Placeholder method 'work', which can be expanded to define specific tasks or responsibilities of the Staff.
    public void work() {
        // Implementation of work-related tasks specific to Staff can be added here.
    }

    // Setter method for 'ability'. Allows the ability of the Staff member to be set or changed after instantiation.
    public void setAbility(String ability) {
        this.ability = ability; // Assigns the new ability value to the 'ability' variable.
    }

    // Getter method for 'ability'. Allows other classes to retrieve the ability or skill of the Staff member.
    public String getAbility() {
        return ability; // Returns the current value of the 'ability' variable.
    }

    // Overridden 'displayInfo' method from the Employee superclass to include ability information specific to the Staff.
    public void displayInfo() {
        super.displayInfo(); // Calls 'displayInfo' from the Employee superclass to display basic employee information.
        System.out.println("Employee is good at " + ability + "."); // Adds additional information about the Staff's ability.
    }
}

package edu.pasadena.cs.cs03b; // Declares the package name for this class, helping in organizing the code and avoiding name conflicts.

// Declaration of an abstract class named 'Person'. An abstract class cannot be instantiated on its own and is meant to be subclassed.
public abstract class Person {
    // A protected variable 'name', accessible within this class, subclasses, and in the same package.
    protected String name;

    // Constructor for the Person class that takes a 'name' as an argument.
    public Person(String name) {
        this.name = name; // Sets the 'name' variable to the value passed to the constructor.
    }

    // Setter method for the 'name' variable. Allows the name of the person to be changed after the object is created.
    public void setName(String name) {
        this.name = name; // Assigns the new name value to the 'name' variable.
    }

    // Getter method for the 'name' variable. Allows other classes to access the name of the person.
    public String getName() {
        return name; // Returns the current value of the 'name' variable.
    }

    // Method to display information about the person. In this case, it prints the name to the console.
    public void displayInfo() {
        System.out.print("Name: " + name + ". "); // Outputs the name of the person followed by a period and a space.
    }
}

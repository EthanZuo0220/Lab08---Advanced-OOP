package edu.pasadena.cs.cs03b;

import java.util.Scanner;
import java.util.Random;

// The CorporateAmerica class encapsulates the functionality for managing a company,
// including its departments, skills, and projects.
public class CorporateAmerica {
   // An Employer object to represent the company's employer.
   Employer employer;

   // A private variable to hold the name of the company.
   private String companyName;

   // Static arrays to hold predefined lists of departments, skills, and projects.
   static String[] department = {
         "Administrative Department", "Human Resources Department", "Finance Department",
         "Marketing Department", "Technical Department", "Legal Department", "Customer Service Department"
   };
   static String[] Skill = {
         "Management", "HR", "Accounting", "Marketing", "Computer", "Legal", "Communication"
   };
   static String[] project = {
         "Clean", "Tax", "Application", "Legal affairs"
   };

   // Default constructor initializes an employer with an empty name and sets the
   // company name to an empty string.
   public CorporateAmerica() {
      employer = new Employer("");
      companyName = "";
   }

   // Constructor with companyName parameter. Initializes an employer with an empty
   // name.
   public CorporateAmerica(String companyName) {
      employer = new Employer("");
      this.companyName = companyName;
   }

   // Constructor with companyName and employerName parameters. Initializes an
   // employer with the given name.
   public CorporateAmerica(String companyName, String employerName) {
      employer = new Employer(employerName);
      this.companyName = companyName;
   }

   // Setter method for companyName.
   public void setCompanyName(String companyName) {
      this.companyName = companyName;
   }

   // Setter method for employer.
   public void setEmployer(Employer employer) {
      this.employer = employer;
   }

   // Getter method for companyName.
   public String getCompanyName() {
      return this.companyName;
   }

   // Getter method for employer.
   public Employer getEmployer() {
      return employer;
   }

   // Static method to assign a random skill from the Skill array.
   public static String assignRandomSkill(String[] arr) {
      Random random = new Random();
      int index = random.nextInt(arr.length); // Generates a random index within the bounds of the array.
      return arr[index]; // Returns the skill at the randomly selected index.
   }

   // Method to display the list of managers and their departments.
   private void displayManagers(Scanner scanner) {
      System.out.println("\nDepartment Managers:");
      for (int i = 0; i < employer.employees.length; i++) {
         if (employer.employees[i] instanceof Manager) {
            System.out.println((i + 1) + " - " + employer.employees[i].getName() + " - "
                  + ((Manager) employer.employees[i]).getDepartment());
         }
      }

      System.out.print("\nEnter number of Manager to view employees, or -1 to go back: ");
      int managerId = scanner.nextInt() - 1; // Adjusts for 0-based indexing.

      // Validates the selection and displays the selected manager's information.
      if (managerId >= 0 && managerId < employer.employees.length && employer.employees[managerId] instanceof Manager) {
         Manager selectedManager = (Manager) employer.employees[managerId];
         selectedManager.displayInfo();
      } else if (managerId != -2) { // -2 after adjustment for 0-based indexing.
         System.out.println("Invalid Manager ID.");
      }
   }

   // Method to start an interactive session that allows the user to view
   // information
   // about the company, departments, and employees.
   public void startInteractiveSession() {
      Scanner scanner = new Scanner(System.in);
      boolean exit = false;

      while (!exit) {
         System.out.println("\nWelcome to Corporate America System");
         System.out.println("1. View Employer Information");
         System.out.println("2. View Department Managers");
         System.out.println("3. View All Company Personnel");
         System.out.println("4. Exit");

         System.out.print("Select an option: ");
         int choice = scanner.nextInt();

         switch (choice) {
            case 1:
               this.employer.displayInfo();
               break;
            case 2:
               displayManagers(scanner);
               break;
            case 3:
               displayAllPersonnel();
               break;
            case 4:
               exit = true;
               System.out.println("ByeBye.");
               break;
            default:
               System.out.println("Invalid option. Please try again.");
         }
      }
   }

   // Method to display information about all personnel in the company, including
   // the employer, managers, staff employees, and contractors.
   public void displayAllPersonnel() {
      int totalEmployers = 1; // Assumes there is one employer.
      int totalManagers = 0;
      int totalStaff = 0;
      int totalContractors = 0;

      // Calculates the number of each type of employee.
      for (Employee employee : employer.employees) {
         if (employee instanceof Manager) {
            totalManagers++;
         } else if (employee instanceof Staff) {
            totalStaff++;
         } else if (employee instanceof Contractor) {
            totalContractors++;
         }
      }

      // Displays the total count of individuals in the company.
      System.out.println("\nWelcome to Pcc Cooperation Company!");
      System.out.println("Total number of individuals in the company: "
            + (totalEmployers + totalManagers + totalStaff + totalContractors));
      System.out.println("Employers: " + totalEmployers);
      System.out.println("Managers: " + totalManagers);
      System.out.println("Staff Employees: " + totalStaff);
      System.out.println("Contractors: " + totalContractors);

      // Displays information about the employer.
      System.out.println("\nEmployer Information:");
      employer.displayInfo();

      // Displays information about all managers.
      System.out.println("\nAll Department Information:");
      for (Employee employee : employer.employees) {
         if (employee instanceof Manager) {
            employee.displayInfo();
         }
      }
   }

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      // Create the manager, staff, contractor objects and manage the association of
      CorporateAmerica corporateAmerica = new CorporateAmerica("Pcc Cooperation Company", "Ethan");
      Manager manager1 = new Manager("John");
      corporateAmerica.getEmployer().addEmployee(manager1);
      Manager manager2 = new Manager("James");
      corporateAmerica.getEmployer().addEmployee(manager2);
      Manager manager3 = new Manager("Susan");
      corporateAmerica.getEmployer().addEmployee(manager3);
      Manager manager4 = new Manager("Jessica");
      corporateAmerica.getEmployer().addEmployee(manager4);
      Manager manager5 = new Manager("David");
      corporateAmerica.getEmployer().addEmployee(manager5);
      Manager manager6 = new Manager("Nancy");
      corporateAmerica.getEmployer().addEmployee(manager6);
      Manager manager7 = new Manager("Jennifer");
      corporateAmerica.getEmployer().addEmployee(manager7);

      Staff staff1 = new Staff("Michael");
      corporateAmerica.getEmployer().addEmployee(staff1);
      Staff staff2 = new Staff("Emma");
      corporateAmerica.getEmployer().addEmployee(staff2);
      Staff staff3 = new Staff("Olivia");
      corporateAmerica.getEmployer().addEmployee(staff3);
      Staff staff4 = new Staff("William");
      corporateAmerica.getEmployer().addEmployee(staff4);
      Staff staff5 = new Staff("Ava");
      corporateAmerica.getEmployer().addEmployee(staff5);
      Staff staff6 = new Staff("Benjamin");
      corporateAmerica.getEmployer().addEmployee(staff6);
      Staff staff7 = new Staff("Sophia");
      corporateAmerica.getEmployer().addEmployee(staff7);
      Staff staff8 = new Staff("Alexander");
      corporateAmerica.getEmployer().addEmployee(staff8);
      Staff staff9 = new Staff("Mia");
      corporateAmerica.getEmployer().addEmployee(staff9);
      Staff staff10 = new Staff("Charlotte");
      corporateAmerica.getEmployer().addEmployee(staff10);
      Staff staff11 = new Staff("Daniel");
      corporateAmerica.getEmployer().addEmployee(staff11);
      Staff staff12 = new Staff("Amelia");
      corporateAmerica.getEmployer().addEmployee(staff12);
      Staff staff13 = new Staff("Matthew");
      corporateAmerica.getEmployer().addEmployee(staff13);
      Staff staff14 = new Staff("Aiden");
      corporateAmerica.getEmployer().addEmployee(staff14);
      Staff staff15 = new Staff("Lucas");
      corporateAmerica.getEmployer().addEmployee(staff15);
      Staff staff16 = new Staff("Jack");
      corporateAmerica.getEmployer().addEmployee(staff16);

      Contractor contractor1 = new Contractor("Henry");
      corporateAmerica.getEmployer().addEmployee(contractor1);
      Contractor contractor2 = new Contractor("Avery");
      corporateAmerica.getEmployer().addEmployee(contractor2);
      Contractor contractor3 = new Contractor("Samuel");
      corporateAmerica.getEmployer().addEmployee(contractor3);
      Contractor contractor4 = new Contractor("Elizabeth");
      corporateAmerica.getEmployer().addEmployee(contractor4);
      Contractor contractor5 = new Contractor("Joseph");
      corporateAmerica.getEmployer().addEmployee(contractor5);

      // Load data into the objects
      System.out.println("The company name is " + corporateAmerica.getCompanyName() + ".");
      System.out.println("Please appoint managers of each department.\n");
      // Assign managers to departments through a user input process.
      for (int i = 0; i < department.length; i++) {
         // Initialize variables for user input and control flow.
         int num = 0;
         boolean flag = true;

         do {
            // Check if the manager position is currently unassigned.
            if (corporateAmerica.getEmployer().employees[i] == null) {
               System.out.println("No manager assigned to index " + i);
               break; // Exit the loop for this iteration if no manager is found.
            }
            // Handle re-assignment attempts.
            if (!flag) {
               System.out.println("This position has been assigned, please select another position.");
            } else {
               // Prompt user to assign a department to the selected manager.
               System.out.println(
                     "The No." + (i + 1) + " manager is " + corporateAmerica.getEmployer().employees[i].getName()
                           + ", Please select the department he is responsible for.\n");
               // List department options for assignment.
               System.out.println(
                     "1. Administrative Department. 2. Human Resources Department. 3. Finance Department. 4. Marketing Department.");
               System.out.println("5. Technical Department. 6. Legal Department. 7. Customer Service Department.");
            }
            num = input.nextInt(); // Collect user input for department selection.
            flag = false; // Update flag after the first input attempt.
         } while (department[num - 1] == null); // Ensure a valid, unassigned department is selected.

         // Assign the selected manager to the chosen department and update their ID.
         if (corporateAmerica.getEmployer().employees[i] != null) { // Only proceed if the employee is not null
            corporateAmerica.getEmployer().employees[i].setId("M00" + (i + 1));
            Manager temp = new Manager(corporateAmerica.getEmployer().employees[i].getName(),
                  corporateAmerica.getEmployer().employees[i].getId(), department[num - 1],
                  corporateAmerica.getEmployer());
            corporateAmerica.getEmployer().employees[i] = temp;
            department[num - 1] = null; // Mark the department as assigned by setting its entry to null.
         }
      }

      System.out.println(
            "\nAutomatically assign each staff to different departments according to their different abilities.\n");
      // Loop through employees, starting after the last manager, to assign skills to
      // staff.
      for (int i = department.length; i < corporateAmerica.getEmployer().employees.length; i++) {
         // Ensure the current employee is a Staff instance and not null.
         if (corporateAmerica.getEmployer().employees[i] != null
               && corporateAmerica.getEmployer().employees[i] instanceof Staff) {
            // Randomly assign a skill to the staff member.
            String skillAssigned = assignRandomSkill(Skill);
            corporateAmerica.getEmployer().employees[i].setId("S00" + (i + 1));
            Staff temp = null;
            // Based on the assigned skill, add the staff member to the appropriate
            // manager's team.
            switch (skillAssigned) {
               // Repeat cases for other skills
               case "Management":
                  // Assign staff to the first manager as an example. Similar logic applies for
                  // other skills and managers.
                  temp = new Staff(corporateAmerica.getEmployer().employees[i].getName(),
                        corporateAmerica.getEmployer().employees[i].getId(), skillAssigned,
                        corporateAmerica.getEmployer().employees[0]);
                  ((Manager) corporateAmerica.getEmployer().employees[0]).addEmployee(temp);
                  break;
               case "HR":
                  temp = new Staff(corporateAmerica.getEmployer().employees[i].getName(),
                        corporateAmerica.getEmployer().employees[i].getId(), skillAssigned,
                        corporateAmerica.getEmployer().employees[1]);
                  ((Manager) corporateAmerica.getEmployer().employees[1]).addEmployee(temp);
                  break;
               case "Accounting":
                  temp = new Staff(corporateAmerica.getEmployer().employees[i].getName(),
                        corporateAmerica.getEmployer().employees[i].getId(), skillAssigned,
                        corporateAmerica.getEmployer().employees[2]);
                  ((Manager) corporateAmerica.getEmployer().employees[2]).addEmployee(temp);
                  break;
               case "Marketing":
                  temp = new Staff(corporateAmerica.getEmployer().employees[i].getName(),
                        corporateAmerica.getEmployer().employees[i].getId(), skillAssigned,
                        corporateAmerica.getEmployer().employees[3]);
                  ((Manager) corporateAmerica.getEmployer().employees[3]).addEmployee(temp);
                  break;
               case "Computer":
                  temp = new Staff(corporateAmerica.getEmployer().employees[i].getName(),
                        corporateAmerica.getEmployer().employees[i].getId(), skillAssigned,
                        corporateAmerica.getEmployer().employees[4]);
                  ((Manager) corporateAmerica.getEmployer().employees[4]).addEmployee(temp);
                  break;
               case "Legal":
                  temp = new Staff(corporateAmerica.getEmployer().employees[i].getName(),
                        corporateAmerica.getEmployer().employees[i].getId(), skillAssigned,
                        corporateAmerica.getEmployer().employees[5]);
                  ((Manager) corporateAmerica.getEmployer().employees[5]).addEmployee(temp);
                  break;
               case "Communication":
                  temp = new Staff(corporateAmerica.getEmployer().employees[i].getName(),
                        corporateAmerica.getEmployer().employees[i].getId(), skillAssigned,
                        corporateAmerica.getEmployer().employees[6]);
                  ((Manager) corporateAmerica.getEmployer().employees[6]).addEmployee(temp);
                  break;
               default:
                  break;
            }
         }
      }
      System.out.println("Outsourcing projects, hiring contractors\n");
      // Assign projects to contractors based on random selection and their
      // acceptance.
      int num = corporateAmerica.getEmployer().NumberOfManager(corporateAmerica.getEmployer().employees)
            + corporateAmerica.getEmployer().NumberOfStaff(corporateAmerica.getEmployer().employees);
      for (int i = num; i < corporateAmerica.getEmployer().employees.length; i++) {
         // Ensure the current employee is a Contractor instance and not null.
         if (corporateAmerica.getEmployer().employees[i] != null) {
            // Randomly assign a project to the contractor.
            String projectAssigned = assignRandomSkill(project);
            System.out.println(
                  "Hiring: " + corporateAmerica.getEmployer().employees[i].getName() + " for " + projectAssigned + ".");
            System.out.println("Contractors have the right to refuse projects.");
            // Determine if the contractor accepts the project.
            Boolean decision = ((Contractor) corporateAmerica.getEmployer().employees[i]).AcceptProject();
            if (!decision) {
               // Remove the contractor if they refuse the project.
               corporateAmerica.getEmployer()
                     .removeEmployeeByName(corporateAmerica.getEmployer().employees[i].getName());
               i--; // Adjust the loop index due to the removal.
               continue;
            } else {
               // Assign the project and update the contractor's ID upon acceptance.
               corporateAmerica.getEmployer().employees[i].setId("C00" + (i + 1));
               Contractor temp = null;
               // Based on the project assigned, add the contractor to the appropriate
               // manager's team.
               switch (projectAssigned) {
                  // Repeat cases for other projects
                  case "Clean":
                     temp = new Contractor(corporateAmerica.getEmployer().employees[i].getName(),
                           corporateAmerica.getEmployer().employees[i].getId(), projectAssigned,
                           corporateAmerica.getEmployer().employees[0]);
                     ((Manager) corporateAmerica.getEmployer().employees[0]).addEmployee(temp);
                     break;
                  case "Tax":
                     temp = new Contractor(corporateAmerica.getEmployer().employees[i].getName(),
                           corporateAmerica.getEmployer().employees[i].getId(), projectAssigned,
                           corporateAmerica.getEmployer().employees[2]);
                     ((Manager) corporateAmerica.getEmployer().employees[2]).addEmployee(temp);
                     break;
                  case "Application":
                     temp = new Contractor(corporateAmerica.getEmployer().employees[i].getName(),
                           corporateAmerica.getEmployer().employees[i].getId(), projectAssigned,
                           corporateAmerica.getEmployer().employees[4]);
                     ((Manager) corporateAmerica.getEmployer().employees[4]).addEmployee(temp);
                     break;
                  case "Legal affairs":
                     temp = new Contractor(corporateAmerica.getEmployer().employees[i].getName(),
                           corporateAmerica.getEmployer().employees[i].getId(), projectAssigned,
                           corporateAmerica.getEmployer().employees[5]);
                     ((Manager) corporateAmerica.getEmployer().employees[5]).addEmployee(temp);
                     break;
               }
            }
         }
      }
      // Start the interactive session to allow user navigation through the system.
      corporateAmerica.startInteractiveSession();
   }
}
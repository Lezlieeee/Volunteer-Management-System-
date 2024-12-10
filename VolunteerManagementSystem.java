import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Volunteer class to store volunteer details
class Volunteer {
    String name;
    String phoneNumber;
    String email;
    String task; 

    // Constructor to initialize volunteer details
    public Volunteer(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.task = "Not assigned";  
    }

    // Method to assign a task to the volunteer
    public void assignTask(String task) {
        this.task = task;
    }

    // Method to display volunteer details
    public void displayVolunteer() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Assigned Task: " + task);
        System.out.println("----------------------------");
    }
}

public class VolunteerManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Volunteer> volunteers = new ArrayList<>();  // List to store volunteers

        while (true) {
            System.out.println("\nVolunteer Management Menu:");
            System.out.println("1. Add Volunteer");
            System.out.println("2. Assign Task to Volunteer");
            System.out.println("3. View All Volunteers");
            System.out.println("4. View Tasks by Volunteer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Add a new volunteer
                    System.out.print("Enter volunteer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter volunteer phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter volunteer email: ");
                    String email = scanner.nextLine();

                    Volunteer volunteer = new Volunteer(name, phoneNumber, email);
                    volunteers.add(volunteer);
                    System.out.println("Volunteer added successfully!");
                    break;

                case 2:
                    // Assign a task to a volunteer
                    System.out.print("Enter volunteer name to assign task: ");
                    String volunteerName = scanner.nextLine();
                    boolean found = false;

                    for (Volunteer v : volunteers) {
                        if (v.name.equalsIgnoreCase(volunteerName)) {
                            System.out.print("Enter task for " + volunteerName + ": ");
                            String task = scanner.nextLine();
                            v.assignTask(task);
                            found = true;
                            System.out.println("Task assigned successfully!");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Volunteer not found.");
                    }
                    break;

                case 3:
                    // View all volunteers and their tasks
                    if (volunteers.isEmpty()) {
                        System.out.println("No volunteers added yet.");
                    } else {
                        System.out.println("\nList of Volunteers:");
                        for (Volunteer v : volunteers) {
                            v.displayVolunteer();
                        }
                    }
                    break;

                case 4:
                    // View tasks by a specific volunteer
                    System.out.print("Enter volunteer name to view tasks: ");
                    String volunteerToView = scanner.nextLine();
                    boolean volunteerFound = false;

                    for (Volunteer v : volunteers) {
                        if (v.name.equalsIgnoreCase(volunteerToView)) {
                            System.out.println("\nVolunteer Details:");
                            v.displayVolunteer();
                            volunteerFound = true;
                            break;
                        }
                    }

                    if (!volunteerFound) {
                        System.out.println("Volunteer not found.");
                    }
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

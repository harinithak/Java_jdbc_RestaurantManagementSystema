package restaurant;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory in = new Inventory();
        Item s = new Item(null, null, 0, 0, 0);
        
        Login l = new Login();
        user u = null;
        boolean isAuthenticated = false;

        while (true) {
            System.out.println("Welcome to Restaurant Management System");
            System.out.println("1. Login");
            System.out.println("2. Logout");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");
            int initialChoice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            if (initialChoice == 1) {
                // Main loop for login
                while (!isAuthenticated) {
                    System.out.println("Username:");
                    String lname = sc.nextLine();
                    System.out.println("Password:");
                    String password = sc.nextLine();
                    
                    u = new user(lname, password);
                    
                    try {
                        if (l.admin(u)) {
                            isAuthenticated = true;
                            System.out.println("Login successful!");
                        } else {
                            throw new InvalidPassword();
                        }
                    } catch (InvalidPassword e) {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                }

                String choice;
                do {
                    System.out.println("1. Add 2. Update 3. Search 4. Remove 5. Show 6. Logout 7. Exit");
                    System.out.print("Enter option: ");
                    int op = sc.nextInt();
                    sc.nextLine();

                    switch (op) {
                        case 1:
                            System.out.println("Enter the id:");
                            s.setID(sc.nextLine());
                            System.out.println("Enter the name:");
                            s.setName(sc.nextLine());
                            System.out.println("Enter the cost:");
                            s.setCost(sc.nextInt());
                            System.out.println("Enter the rating:");
                            s.setRating(sc.nextInt());
                            System.out.println("Enter the Quantity:");
                            s.setQty(sc.nextInt());
                            in.addP(s);
                            break;
                        case 2:
                            System.out.println("Enter the name to be updated:");
                            String name = sc.next();
                            System.out.println("Enter the cost to be updated:");
                            int cost = sc.nextInt();
                            s.setName(name);
                            s.setCost(cost);
                            in.update(s);
                            break;
                        case 3:
                            System.out.println("Enter the ID to search:");
                            String ids = sc.nextLine();
                            s = in.search(ids);
                            System.out.println(s);
                            break;
                        case 4:
                            System.out.println("Enter the id to be deleted:");
                            String idr = sc.nextLine();
                            in.Remove(idr);
                            break;
                        case 5:
                            in.show();
                            break;
                        case 6:
                            isAuthenticated = false; // Set to false to trigger re-login
                            System.out.println("You have been logged out. Please log in again.");
                            break;
                        case 7:
                            System.out.println("Exiting the system. Goodbye!");
                            sc.close();
                            System.exit(0); // Exit the application
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }

                    System.out.println("Enter 'yes' to continue or 'No' to stop:");
                    choice = sc.nextLine();
                } while (!choice.equalsIgnoreCase("No"));
                
                isAuthenticated = false; 
            } else if (initialChoice == 2) {
                if (isAuthenticated) {
                    isAuthenticated = false;
                    System.out.println("You have been logged out. Please log in again.");
                } else {
                    System.out.println("You are not logged in.");
                }
            } else if (initialChoice == 3) {
                System.out.println("Exiting the system. Goodbye!");
                sc.close();
                System.exit(0); 
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

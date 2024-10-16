
package student.n;
import java.util.Scanner;
import sun.security.krb5.Config;
public class StudentN {
    
    public static void main(String[] args) {

 
        Scanner sc = new Scanner(System.in);
        String response;
        StudentN studentManager = new StudentN();
        
        do {
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            
            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            
            switch (action) {
                case 1:
                    studentManager.addStudent();
                    break;
                case 2:
                    studentManager.viewStudents();
                    break;
                case 3:
                    studentManager.viewStudents();
                    studentManager.updateStudent();
                    break;
                case 4:
                    studentManager.viewStudents();
                    studentManager.deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
            }
            System.out.print("Do you want to continue? (yes/no): ");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));
        
        System.out.println("Thank you!");
        sc.close(); // Close the scanner
    }

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        config conf = new config(); // Assuming Config is defined elsewhere
        
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Address: ");
        String address = sc.next();
        System.out.print("Phone Number: ");
        String phoneNumber = sc.next();

        String sql = "INSERT INTO Student (s_name, s_age, s_email, s_address, s_phonenumber) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, name, age, email, address, phoneNumber);
    }

    public void viewStudents() {
        config conf = new config(); 
        String query = "SELECT * FROM Student";
        String[] headers = {"ID", "Name", "Age", "Email", "Address", "Phone Number"};
        String[] columns = {"s_id", "s_name", "s_age", "s_email", "s_address", "s_phonenumber"};

        conf.viewRecords(query, headers, columns);
    }

    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("New Name: ");
        String newName = sc.next();
        System.out.print("New Age: ");
        int newAge = sc.nextInt();
        System.out.print("New Email: ");
        String newEmail = sc.next();
        System.out.print("New Address: ");
        String newAddress = sc.next();
        System.out.print("New Phone Number: ");
        String newPhoneNumber = sc.next();
        
        String qry = "UPDATE Student SET s_name = ?, s_age = ?, s_email = ?, s_address = ?, s_phonenumber = ? WHERE s_id = ?";
        config conf = new config(); // Assuming Config is defined elsewhere
        conf.updateRecord(qry, newName, newAge, newEmail, newAddress, newPhoneNumber, id);
    }

    public void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the ID to delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM Student WHERE s_id = ?";
        config conf = new config(); 
        conf.deleteRecord(qry, id);
    }
}


     
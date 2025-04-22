import java.util.Scanner;
class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}
class InvalidEmployeeIdException extends Exception {
    public InvalidEmployeeIdException(String message) {
        super(message);
    }
}
class InvalidDepartmentIdException extends Exception {
    public InvalidDepartmentIdException(String message) {
        super(message);
    }
}
public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Employee ID: ");
            int empId = Integer.parseInt(scanner.nextLine());
            if (empId < 2001 || empId > 5001) {
                throw new InvalidEmployeeIdException("Employee ID must be between 2001 and 5001.");
            }
            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();
            if (name.isEmpty() || !Character.isUpperCase(name.charAt(0))) {
                throw new InvalidNameException("First letter of employee name must be capital.");
            }
            System.out.print("Enter Department ID: ");
            int deptId = Integer.parseInt(scanner.nextLine());
            if (deptId < 1 || deptId > 5) {
                throw new InvalidDepartmentIdException("Department ID must be between 1 and 5.");
            }
            System.out.println("\nEmployee Details:");
            System.out.println("ID: " + empId);
            System.out.println("Name: " + name);
            System.out.println("Department ID: " + deptId);
        } catch (InvalidNameException | InvalidEmployeeIdException | InvalidDepartmentIdException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Input Error: Please enter valid numbers for Employee ID and Department ID.");
        } finally {
            scanner.close();
        }
    }
}

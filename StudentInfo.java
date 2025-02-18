/*Write a java program to take input as a command line argument. Your name, course, universityrollno and semester. Display the information.*/
public class StudentInfo {
    public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length < 4) {
            System.out.println("Usage: java StudentInfo <Name> <UniversityRollNo> <Course> <Semester>");
            return;
        }

        // Assigning command-line arguments to variables
        String name = args[0];
        String universityRollNo = args[1];
        String course = args[2];
        String semester = args[3];

        // Displaying the information
        System.out.println("Name: " + name);
        System.out.println("University Roll No: " + universityRollNo);
        System.out.println("Course: " + course);
        System.out.println("Semester: " + semester);
    }
}

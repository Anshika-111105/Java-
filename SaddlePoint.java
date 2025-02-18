import java.util.Scanner;

public class SaddlePoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();    
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }   
        findSaddlePoint(matrix, rows, cols);
        scanner.close();
    }
    
    public static void findSaddlePoint(int[][] matrix, int rows, int cols) {
        boolean found = false;
        
        for (int i = 0; i < rows; i++) {
            int minRowValue = matrix[i][0];
            int minColIndex = 0;
            
            // Find the minimum element in the current row
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] < minRowValue) {
                    minRowValue = matrix[i][j];
                    minColIndex = j;
                }
            }
            
            // Check if this element is the maximum in its column
            boolean isSaddlePoint = true;
            for (int k = 0; k < rows; k++) {
                if (matrix[k][minColIndex] > minRowValue) {
                    isSaddlePoint = false;
                    break;
                }
            }
            
            if (isSaddlePoint) {
                System.out.println("Saddle Point found at (Row: " + i + ", Column: " + minColIndex + ") with value: " + minRowValue);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No Saddle Point found in the matrix.");
        }
    }
}
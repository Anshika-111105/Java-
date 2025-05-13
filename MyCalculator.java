import java.util.*;
public class MyCalculator {
    public long power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n and p should be non negative");
        }
        if (n == 0 && p == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 0; i < p; i++) {
            result *= n;
        }
        
        return result;
    }
    public static void main(String[] args) {
        MyCalculator calculator = new MyCalculator();
        try {
            System.out.println(calculator.power(2, 3)); // Should output 8
            System.out.println(calculator.power(3, 4)); // Should output 81
            System.out.println(calculator.power(0, 0)); 
            System.out.println(calculator.power(-1, 2)); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.println(calculator.power(2, -3)); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            
            try {
                System.out.println(calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
        
    }
}
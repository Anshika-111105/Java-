import java.util.Scanner;

public class ReplaceOnesWithZeros {
    public static int replaceDigits(int num) {
        int result = 0, place = 1;
        
        if (num == 0) return 1; // Special case for 0
        
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0) {
                digit = 1;
            } else if (digit == 1) {
                digit = 0;
            }
            result += digit * place;
            place *= 10;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        
        int newNum = replaceDigits(num);
        System.out.println("Output: " + newNum);
        
        sc.close();
    }
}

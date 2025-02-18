import java.util.Scanner;

public class BankDepositCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose deposit type:");
        System.out.println("1. Term Deposit");
        System.out.println("2. Recurring Deposit");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                // Term Deposit Calculation
                System.out.print("Enter Principal amount (P): ");
                double p1 = sc.nextDouble();
                System.out.print("Enter Rate of Interest (R) in %: ");
                double r1 = sc.nextDouble();
                System.out.print("Enter Time Period (N) in years: ");
                int n1 = sc.nextInt();
                double a1 = p1 * Math.pow((1 + r1 / 100), n1);
                System.out.printf("Maturity Amount: %.2f\n", a1);
                break;

            case 2:
                // Recurring Deposit Calculation
                System.out.print("Enter Monthly Installment (P): ");
                double p2 = sc.nextDouble();
                System.out.print("Enter Rate of Interest (R) in %: ");
                double r2 = sc.nextDouble();
                System.out.print("Enter Time Period (N) in months: ");
                int n2 = sc.nextInt();
                double a2 = (p2 * n2) + (p2 * n2 * (n2 + 1) / 2 * r2 / 100 * 1 / 12);
                System.out.printf("Maturity Amount: %.2f\n", a2);
                break;

            default:
                System.out.println("Invalid choice! Please enter 1 or 2.");
        }
        sc.close();
    }
}
 
    


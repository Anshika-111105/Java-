import java.util.ArrayList;
import java.util.Scanner;

class Bank {
    private static int accountCounter = 1001; // Starting account number
    private String name;
    private String address;
    private int accountNumber;
    private double balance;
    public Bank(String name, String address, double balance) {
        this.name = name;
        this.address = address;
        this.accountNumber = accountCounter++;
        this.balance = balance;
    }
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Balance: (INR)" + balance);
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
        }
    }
    public void changeAddress(String newAddress) {
        this.address = newAddress;
        System.out.println("Address updated successfully!");
    }
    public int getAccountNumber() {
        return accountNumber;
    }
}
public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Bank> accounts = new ArrayList<>();
        System.out.print("Enter number of depositors: ");
        int numDepositors = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numDepositors; i++) {
            System.out.println("\nEnter details for depositor " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Initial Balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            accounts.add(new Bank(name, address, balance));
            System.out.println("Account created successfully! Account Number: " + accounts.get(i).getAccountNumber());
        }
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Display account information");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Change address");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the program. Thank you!");
                break;
            }

            System.out.print("Enter account number: ");
            int accNum = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Bank selectedAccount = null;
            for (Bank acc : accounts) {
                if (acc.getAccountNumber() == accNum) {
                    selectedAccount = acc;
                    break;
                }
            }

            if (selectedAccount == null) {
                System.out.println("Account not found! Try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    selectedAccount.displayInfo();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    selectedAccount.deposit(depositAmount);
                    selectedAccount.displayInfo();
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    selectedAccount.withdraw(withdrawAmount);
                    selectedAccount.displayInfo();
                    break;
                case 4:
                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();
                    selectedAccount.changeAddress(newAddress);
                    selectedAccount.displayInfo();
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }

        scanner.close();
    }
}

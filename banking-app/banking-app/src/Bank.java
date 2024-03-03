import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        BankAccount myBankAccount = new BankAccount("John", "12");


        myBankAccount.showMenu();
    }
}

class BankAccount {
    private int balance = 0;
    private int previousTransaction = 0;
    private String customerName;
    private String customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
        }
    }

    void withdraw(int amount) {
        if (amount == 0)
            return;

        if (balance >= amount) {
            balance = balance - amount;
            previousTransaction = -amount;
        } else {
            System.out.println("Error: Amount withdrawn cannot exceed bank balance");
        }
    }

    int getBalance() {
        return this.balance;
    }

    int getPreviousTransation() {

        if (this.previousTransaction > 0) {
            System.out.println("Deposited: " + this.previousTransaction);
        } else if (this.previousTransaction < 0) {
            System.out.println("Withdrawn: " + this.previousTransaction);
        } else {
            System.out.println("No transaction occured");
        }

        return this.previousTransaction;
    }

    String getCustomerName() {
        return this.customerName;
    }

    String getCustomerId() {
        return this.customerId;
    }

    void printAccount() {
        System.out.println("Name: " + this.customerName);
        System.out.println("ID: " + this.getCustomerId());
        System.out.println("Balance: " + this.getBalance());
        System.out.println("Last Transaction: " + this.getPreviousTransation());
    }

    void showMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            char option = '\0';

            System.out.println("**********************************");
            System.out.println("Welcome to your bank account, " + this.customerName);
            System.out.println("Your ID is " + this.customerId + "\n\n");
            System.out.println("**********************************");

            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transaction");
            System.out.println("E. Exit");

            option = scanner.next().charAt(0);
            do {
                System.out.println("**********************************");
                System.out.println("Enter an option");
                System.out.println("**********************************");
                option = scanner.next().charAt(0);
                System.out.println("\n");

                switch (option) {
                    case 'A':
                        System.out.println("----------------------------------------");
                        System.out.println("Your balance is: \t\t " + this.getBalance());
                        System.out.println("----------------------------------------");
                        break;

                    case 'B':
                        System.out.println("----------------------------------------");
                        System.out.println("Enter amount to deposit");
                        System.out.println("----------------------------------------");
                        int deposit = scanner.nextInt();
                        this.deposit(deposit);

                        if (deposit == 0) {
                            break;
                        }

                        System.out.println("Deposit successful. Your new balance is $" + this.getBalance());
                        break;
                    case 'C':
                        System.out.println("----------------------------------------");
                        System.out.println("Enter an amount to withdraw");
                        System.out.println("----------------------------------------");
                        int withdraw = scanner.nextInt();

                        if (withdraw > this.getBalance()) {
                            System.out.println("Insufficient funds");
                            break;
                        }
                        this.withdraw(withdraw);

                        System.out.println("Your new balance is $" + this.getBalance());
                        break;
                    case 'D':
                        System.out.println("----------------------------------------");
                        System.out.println("Your previous transaction: ");
                        this.getPreviousTransation();
                        System.out.println("----------------------------------------");
                        break;
                    case 'E':
                        option = 'E';
                        break;
                    default:
                        System.out.println("Invalid input, please try again");
                        break;
                }

                System.out.println("\n\n\n\n");

            } while (option != 'E');

            System.out.println("Thanks for visiting");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
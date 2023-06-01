import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
  private String accountNumber;
  private String accountHolderName;
  private double balance;

  public BankAccount(String accountNumber, String accountHolderName) {
    this.accountNumber = accountNumber;
    this.accountHolderName = accountHolderName;
    this.balance = 0.0;
  }

  public void deposit(double amount) {
    if (amount >= 5000) {
      balance += amount;
      System.out.println("Rs " + amount + " deposited successfully.");
    } else {
      System.out.println("RS " + amount + " is less !! You have to deposit amount more than 5000 RS.");

    }

  }

  public void withdraw(double amount) {
    if(amount > 0){
      if (balance >= amount) {
        balance -= amount;
        System.out.println("RS " + amount + " withdrawn successfully.");
      } else {
        System.out.println("Insufficient balance.");
      }
    }else{
      System.out.println("Withdraw Amount should not less than 0");
    }
    
  }

  public void checkBalance() {
    System.out.println("Account balance: RS " + balance);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter account number: ");
    String accountNumber = scanner.nextLine();

    System.out.print("Enter account holder name: ");
    String accountHolderName = scanner.nextLine();

   

    BankAccount account = new BankAccount(accountNumber, accountHolderName);

    int choice = 0;

    do {
      System.out.println("1. Deposit");
      System.out.println("2. Withdraw");
      System.out.println("3. Check balance");
      System.out.println("4. Exit");

      System.out.print("Enter your choice: ");

      try {
        choice = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Wrong input. Please enter a number.");
        scanner.nextLine();
        continue;
      }

      switch (choice) {
        case 1:
          System.out.print("Enter amount to deposit: ");
          double depositAmount = 0.0;
          try {
            if (scanner.hasNextInt()) {
              depositAmount = scanner.nextInt();

            } else if (scanner.hasNextDouble()) {
              depositAmount = scanner.nextDouble();

            } else {
              throw new InputMismatchException();
            }
          } catch (InputMismatchException e) {
            System.out.println("Wrong input. Please enter a number.");
            scanner.nextLine();
            continue;

          }
          account.deposit(depositAmount);
          break;
        case 2:
          System.out.print("Enter amount to withdraw: ");
          double withdrawAmount;
          try {
            if (scanner.hasNextInt()) {
               withdrawAmount = scanner.nextInt();

            } else if (scanner.hasNextDouble()) {
              withdrawAmount = scanner.nextDouble();

            } else {
              throw new InputMismatchException();
            }
          } catch (InputMismatchException e) {
            System.out.println("Wrong input. Please enter a number.");
            scanner.nextLine();
            continue;

          }
          
          account.withdraw(withdrawAmount);
          break;
        case 3:
          account.checkBalance();
          break;
        case 4:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
          break;
      }

      System.out.println();
    } while (choice != 4);

    scanner.close();
  }

 
}

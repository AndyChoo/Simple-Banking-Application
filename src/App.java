import java.util.Scanner;

public class App {
    public static void printMenu() {
        System.out.println("-----------------------");
        System.out.println("Please pick an action: ");
        System.out.println("1. Add account");
        System.out.println("2. Find account");
        System.out.println("3. Transfer");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Exit");
        System.out.println("-----------------------");
    }
    // SavingsAccount CJS = new SavingsAccount("164119188501", "CJS", 10_000, 5);
    // CurrentAccount JavaGlobal = new CurrentAccount("164119188502", "JavaGlobal", 10_000, 1000);
    // CJS.addInterest();
    // JavaGlobal.withdraw(10_000);
    // bank.transferFunds("164119188501", "164119188509", 500);
    // CJS.checkBalance();
    // JavaGlobal.checkBalance();
    // CJS.checkTransactionHistory();
    // JavaGlobal.checkTransactionHistory();

    public static void main(String[] args) throws Exception {
        
        Bank bank = new Bank();
        
        Scanner scanner = new Scanner(System.in);
        while(true) {
            printMenu();
            int selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    bank.addAccount();
                    break;
                case 2:
                    bank.displayAccount();
                    break;
                case 3:
                    bank.transferFunds();
                    break;
                case 4:
                    bank.deposit();
                    break;
                case 5:
                    bank.withdraw();
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    return;
                default:
                    System.err.println("Invalid action.");
                    break;
            }
        }
    }
}

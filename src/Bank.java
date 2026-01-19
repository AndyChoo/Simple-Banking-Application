import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount() {
        Scanner scanner = new Scanner(System.in);
        String accountNumber;
        String accountHolder;
        Integer balance;

        System.out.print("Account number: ");
        accountNumber = scanner.next();
        System.out.print("Account holder: ");
        accountHolder = scanner.next();
        while(true) {
            System.out.print("Balance: ");
            balance = Integer.parseInt(scanner.next());
            if(balance>0) break;
            System.out.println("Please enter a valid balance.");
        }
        Account account = new Account(accountNumber, accountHolder, balance);
        accounts.add(account);
        System.out.println("Account added: " + account.getAccountNumber());
    }

    public Account findAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Account number: ");
        String accountNumber = scanner.next();
        for(Account account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    public void displayAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Account number: ");
        String accountNumber = scanner.next();
        for(Account account : accounts) {
            if(account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account number: " + account.getAccountNumber());
                System.out.println("Account holder: " + account.getAccountHolder());
                account.checkBalance();
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void displayAccountNumber(Account account) {
        System.out.print(account.getAccountNumber());
    }

    public void transferFunds() {
        Scanner scanner = new Scanner(System.in);
        
        Optional<Account> fromAccount = Optional.ofNullable(findAccount());
        Optional<Account> toAccount = Optional.ofNullable(findAccount());

        while(fromAccount.isPresent() && toAccount.isPresent()) {
            System.out.print("Amount: ");
            Integer amount = Integer.parseInt(scanner.next());
            if(amount>0) {
                fromAccount.ifPresent(acc -> acc.withdraw(amount));
                toAccount.ifPresent(acc -> acc.deposit(amount));
                System.out.println(
                    "Transferred " + amount +
                    " from " + fromAccount.get().getAccountNumber() +
                    " to " + toAccount.get().getAccountNumber()
                );
                break;
            }
            System.out.println("Please enter a valid amount.");
        }
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        Optional<Account> account = Optional.ofNullable(findAccount());

        while(account.isPresent()) {
            System.out.print("Amount: ");
            Integer amount = Integer.parseInt(scanner.next());
            if(amount>0) {
                account.ifPresent(acc -> acc.deposit(amount));
                break;
            }
            System.out.println("Please enter a valid amount.");
        }
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        Optional<Account> account = Optional.ofNullable(findAccount());

        while(account.isPresent()) {
            System.out.print("Amount: ");
            Integer amount = Integer.parseInt(scanner.next());
            if(amount>0) {
                account.ifPresent(acc -> acc.withdraw(amount));
                break;
            }
            System.out.println("Please enter a valid amount.");
        }
    }
}

package _08.OOP._01.Encapsulation;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(250); //prints "Deposit of $250.0 is successful, account balance = $250.0"
        account.withdraw(50); //prints "Withdrawal of $50.0 is successful, account balance = $200.0"
        account.withdraw(200); //prints "Withdrawal of $200.0 is successful, account balance = $0.0"

        account.deposit(100); //prints "Deposit of $100.0 is successful, account balance = $100.0"
        account.withdraw(45.55); //prints "Withdrawal of $45.55 is successful, account balance = $54.45"
        account.withdraw(54.46); //prints "Insufficient balance, account balance = $54.45"

        System.out.println(account.getAccountBalance()); //prints "54.45"

    }
}

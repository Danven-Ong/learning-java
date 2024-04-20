package _08.OOP._01.Encapsulation;

public class Account {

    //Creating a private attribute/field
    private double accountBalance;

    //Creating a getter method
    public double getAccountBalance() {
        return accountBalance;
    }

    //Creating a setter method
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    //Creating behavioral methods
    public void deposit(double funds) {
        this.accountBalance += funds; //using this keyword is optional
        System.out.println("Deposit of $" + funds + " is successful, account balance = $" + accountBalance);
    }

    public void withdraw(double funds) {
        if (funds > accountBalance) {
            System.out.println("Insufficient balance, account balance = $" + accountBalance);
        } else {
            accountBalance -= funds;
            System.out.println("Withdrawal of $" + funds + " is successful, account balance = $" + accountBalance);
        }
    }
}

//Only one class in source file can be public
//Creating another class will not be publicly accessible outside the package
class anotherCLass {
}

package _08.OOP._02.Constructors;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Tim", 2000, "tim@gmail.com");
        System.out.println(customer.getName()); //prints "Tim"
        System.out.println(customer.getCreditLimit()); //prints "2000.0"
        System.out.println(customer.getEmail()); //prints "tim@gmail.com"

        Customer secondCustomer = new Customer("Joe", "joe@gmail.com");
        System.out.println(secondCustomer.getName()); //prints "Joe"
        System.out.println(secondCustomer.getCreditLimit()); //prints "1000.0"
        System.out.println(secondCustomer.getEmail()); //prints "joe@gmail.com"

        Customer thirdCustomer = new Customer(); //prints "Empty constructor was called"
        System.out.println(thirdCustomer.getName()); //prints "Nobody"
        System.out.println(thirdCustomer.getCreditLimit()); //prints "1000.0"
        System.out.println(thirdCustomer.getEmail()); //prints "No email"
    }
}

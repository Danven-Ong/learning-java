package _16.NestedClass.InnerClass;

public class Meal {

    private double price = 5.0;
    //Both inner and outer class has access to all outer classes' private fields and vice versa
    private Item burger; //Use of inner class type is supported
    private Item drink;
    private Item side;
    private double conversionRate;

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burger = new Item("regular", "burger");
        drink = new Item("coke", "drink", 1.5);
        side = new Item("fries", "side", 2.0);
    }

    public double getTotal() {

        double total = burger.price + drink.price + side.price;
        return Item.getPrice(total, conversionRate); //calling static method from inner class
    }
    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side, "Total Due: ", getTotal());
    }

    //Creating non-static inner class
    private class Item {

        private String name;
        private String type;
        private double price;
        public Item(String name, String type) {
            //Specify outer class name followed by this to refer to price in outer class (Meal)
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name,
                    getPrice(price, conversionRate));
        }

        //Static method in nested class (JDK 17)
        public static double getPrice(double price, double rate) {
            return price * rate;
        }
    }

}

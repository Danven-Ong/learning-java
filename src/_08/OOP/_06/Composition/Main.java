package _08.OOP._06.Composition;

public class Main {
    public static void main(String[] args) {

        SmartKitchen kitchen = new SmartKitchen();

        kitchen.setKitchenState(true, false, true);
        kitchen.doKitchenWork(); //prints "Brewing coffee", "Washing dishes"
    }
}

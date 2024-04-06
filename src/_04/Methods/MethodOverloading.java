package _04.Methods;

public class MethodOverloading {
    public static void main(String[] args) {
        methodOne(5);

        methodOne(5.0f);

        methodOne(5, 5.0f);

        methodOne(5.0f, 5);

        System.out.println(myScore("Alex", 500));
        System.out.println(myScore(500));
    }

    public static void methodOne(int first) {
        System.out.println(first);
    }
    //method is overloaded when it has the same name but different method signature
    //return type and name of parameters is not part of the signature

    //valid overloaded methods
    //1. different type of parameters
    public static void methodOne(float first) {
        System.out.println(first);
    }

    //2. different number of parameters
    public static void methodOne(int first, float second) {
        System.out.println(first);
        System.out.println(second);
    }

    //3. order of parameters
    public static void methodOne(float second, int first) {
        System.out.println(second);
        System.out.println(first);
    }


    //application of method overloading
    public static int myScore(String name, int score) {
        System.out.println("Player " + name + " scored " + score);
        return score;
    }

    public static int myScore(int score) {
        return myScore("Anonymous", score);
    }
}

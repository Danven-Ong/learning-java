package _15.Generics.Extras;

public class NewStudent extends Student{

    private double percentComplete;

    public NewStudent() {
        //super() is implicitly called
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }
}

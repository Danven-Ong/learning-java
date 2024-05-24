package _17.Lambda.Basics;

//Creating a functional interface
@FunctionalInterface //Annotation to create a functional interface
public interface Operation<T> {

    T operate(T value1, T value2);
}

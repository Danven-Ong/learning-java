package _08.OOP._04.DataTransferObjects.Record;

//Using record class
public record Teacher(String name, String dateOfBirth) {
    //Creates private final field for each component and initialises it by calling constructor
    //Calling constructors with parameters and printing data out (similar to toString() in POJOs) are implicitly
    //part of the record
    //Does not support setter methods as it aims to be immutable
}

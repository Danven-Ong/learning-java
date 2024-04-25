package _08.OOP._04.DataTransferObjects.POJO;

public class Student {
    private String name;
    private String dateOfBirth;

    public Student(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    //This method allow us to print the current state of our object
    @Override //Annotation, ensures method is overridden smoothly
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}

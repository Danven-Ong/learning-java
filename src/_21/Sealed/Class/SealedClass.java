package _21.Sealed.Class;

//Subclasses must be final, sealed or non-sealed
public sealed class SealedClass extends SpecialAbstractClass permits SubClass{ //Sealed classes must have subclasses
}


final class SubClass extends SealedClass {

}

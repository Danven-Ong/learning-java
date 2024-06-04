package _21.Sealed.Class;


//Subclasses must be permitted to inherit from sealed parent class
//Subclasses must be final, sealed or non-sealed
public sealed class SpecialAbstractClass permits SpecialAbstractClass.NestedClass,
        NonSealedClass, SealedClass, FinalClass{ //Sealed classes must have subclasses

    final class NestedClass extends SpecialAbstractClass{ //Permitting nested class, must use qualifying outer class name

    }
}

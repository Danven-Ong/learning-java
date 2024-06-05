package _21.Sealed.Interface;

public sealed interface SealedInterface permits BetterInterface, StringChecker{
    //Needs to permit both interface and classes that implements/extends sealed interface

    boolean testData();
}

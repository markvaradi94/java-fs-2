package ro.fasttrackit.course2.interfaces;

public interface Pet {
    String NAME = "PET";

    String getName();

    String makeSound();

    default String phrase() {
        logPhraseCall();
        return getName() + ": " + makeSound();
    }

    default String getColour() {
        return "BROWN";
    }

    private void logPhraseCall() {
        System.out.println("phrase() method was called");
    }
}

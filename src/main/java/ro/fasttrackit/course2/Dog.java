package ro.fasttrackit.course2;

public class Dog extends Pet {
    private int tailLength;

    public Dog(String name) {
        super(name);
    }

    @Override
    protected String makeSound() {
        return "woof";
    }

    @Override
    Dog friend() {
        return new Dog("lola");
    }

    public int getTailLength() {
        return tailLength;
    }
}

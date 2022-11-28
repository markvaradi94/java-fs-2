package ro.fasttrackit.course2;

abstract class Pet {
    private final String name;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    protected abstract String makeSound();

    abstract Pet friend();
}
package ro.fasttrackit.course2.countries;

import java.util.Optional;
import java.util.stream.Stream;

public enum Continent {
    EUROPE,
    ASIA,
    OCEANIA,
    AFRICA,
    AMERICAS;

    public static Optional<Continent> of(String continentName) {
        return Stream.of(values())
                .filter(val -> val.name().equalsIgnoreCase(continentName))
                .findFirst();
    }
}

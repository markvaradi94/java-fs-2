package ro.fasttrackit.course2.countries;

import java.util.List;

public interface ICountry {
    String name();

    String capital();

    long population();

    long area();

    Continent continent();

    List<String> neighbours();
}

package ro.fasttrackit.course2.countries.composition;

import ro.fasttrackit.course2.countries.Country;

import java.util.List;

public interface CountryProvider {
    List<Country> readCountries();
}

package ro.fasttrackit.course2.countries.composition;

import ro.fasttrackit.course2.countries.Country;

import java.util.List;

import static ro.fasttrackit.course2.countries.Continent.EUROPE;

public class InMemoryCountryProvider implements CountryProvider {
    @Override
    public List<Country> readCountries() {
        return List.of(
                Country.builder()
                        .name("Moldova")
                        .capital("Chisinau")
                        .population(6_000_000)
                        .area(523452)
                        .neighbours(List.of("ROU"))
                        .continent(EUROPE)
                        .build()
        );
    }
}

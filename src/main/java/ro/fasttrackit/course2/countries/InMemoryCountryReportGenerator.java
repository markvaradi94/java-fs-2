package ro.fasttrackit.course2.countries;

import java.util.List;

import static ro.fasttrackit.course2.countries.Continent.EUROPE;

public class InMemoryCountryReportGenerator extends CountryReportGenerator {
    @Override
    protected List<Country> readCountries() {
        return List.of(Country.builder()
                .name("Romania")
                .capital("Bucharest")
                .continent(EUROPE)
                .neighbours(List.of("HUN", "BLG", "UKR", "SRB", "MLD"))
                .area(23132123)
                .population(19_000_000)
                .build());
    }
}

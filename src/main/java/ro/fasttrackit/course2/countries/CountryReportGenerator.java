package ro.fasttrackit.course2.countries;

import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.lang.Long.parseLong;
import static java.util.Optional.ofNullable;

abstract class CountryReportGenerator {

    @SneakyThrows
    public void generateReport(String outputFile) {
        List<Country> countries = readCountries();
        writeReport(countries, outputFile);
    }

    public void writeReport(List<Country> countries, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            countries.stream()
                    .map(country -> country.name() + "," + country.capital())
                    .forEach(line -> writeLine(writer, line));
        }
    }

    protected abstract List<Country> readCountries();

    private List<OldSchoolCountry> readOldSchoolCountries() {
        return null;
    }

    Country mapToCountry(String line) {
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        String capital = tokens[1];
        long population = parseLong(tokens[2]);
        long area = parseLong(tokens[3]);
        String continent = tokens[4];
        String neighboursString = tokens.length > 5 ? tokens[5] : null;

        return Country.builder()
                .name(name)
                .capital(capital)
                .population(population)
                .area(area)
                .continent(Continent.of(continent)
                        .orElse(null))
                .neighbours(constructNeighboursList(neighboursString))
                .build();
    }

    OldSchoolCountry mapToOldSchoolCountry(String line) {
        Country source = mapToCountry(line);
        return OldSchoolCountry.builder()
                .name(source.name())
                .capital(source.capital())
                .population(source.population())
                .area(source.area())
                .continent(source.continent())
                .neighbours(source.neighbours())
                .build();
    }

    private List<String> constructNeighboursList(String neighboursString) {
        return ofNullable(neighboursString)
                .map(str -> str.split("~"))
                .stream()
                .map(Arrays::asList)
                .flatMap(Collection::stream)
                .toList();
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package ro.fasttrackit.course2.countries.composition;

import lombok.SneakyThrows;
import ro.fasttrackit.course2.countries.Country;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportGenerator {
    private final CountryProvider countryProvider;

    public ReportGenerator(CountryProvider countryProvider) {
        this.countryProvider = countryProvider;
    }

    @SneakyThrows
    public void generateReport(String outputFile) {
        List<Country> countries = countryProvider.readCountries();
        writeReport(countries, outputFile);
    }

    private void writeReport(List<Country> countries, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            countries.stream()
                    .map(country -> country.name() + "," + country.capital())
                    .forEach(line -> writeLine(writer, line));
        }
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

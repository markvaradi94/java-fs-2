package ro.fasttrackit.course2.countries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileCountryReportGenerator extends CountryReportGenerator {
    private final String sourceFile;

    public FileCountryReportGenerator(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    protected List<Country> test() {
        try {
            return Files.lines(Path.of(sourceFile))
                    .map(this::mapToCountry)
                    .toList();
        } catch (IOException e) {
            System.err.println("Could not read from file " + sourceFile);
        }
        return List.of();
    }

    @Override
    protected List<Country> readCountries() {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            return reader.lines()
                    .map(this::mapToCountry)
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

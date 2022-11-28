package io.mbm.homework.exercise2.composition;

import io.mbm.homework.exercise2.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;

public class FilePeopleReportWriter implements PeopleReportWriter {
    private final String outputFile;

    public FilePeopleReportWriter(String outputFile) {
        this.outputFile = outputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    @Override
    public void writeReport(List<Person> people) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            people.stream()
                    .collect(groupingBy(person -> person.ageGroup().getGroupKey(), TreeMap::new, mapping(person -> person.firstName() + " " + person.lastName(), joining(", "))))
                    .entrySet()
                    .forEach(entry -> writeLine(writer, entry));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeLine(BufferedWriter writer, Entry<String, String> entry) {
        try {
            writer.write(entry.getKey() + ": " + entry.getValue());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

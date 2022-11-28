package io.mbm.homework.exercise2.inheritance;

import io.mbm.homework.exercise2.Person;
import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;

abstract class PersonReportGenerator {

    @SneakyThrows
    public void generateReport(String outputFile) {
        List<Person> people = readPeople();
        writeReport(people, outputFile);
    }

    public void writeReport(List<Person> people, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            people.stream()
                    .collect(groupingBy(person -> person.ageGroup().getGroupKey(), TreeMap::new, mapping(this::fullName, joining(", "))))
                    .entrySet()
                    .forEach(entry -> writeLine(writer, entry));
        }
    }

    protected abstract List<Person> readPeople();

    Person mapToPerson(String line) {
        String[] tokens = line.split(",");
        return Person.builder()
                .firstName(tokens[0])
                .lastName(tokens[1])
                .age(Integer.parseInt(tokens[2]))
                .build();
    }

    private String fullName(Person person) {
        return person.firstName() + " " + person.lastName();
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

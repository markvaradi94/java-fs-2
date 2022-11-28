package io.mbm.homework.exercise2.composition;

import io.mbm.homework.exercise2.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FilePeopleProvider implements PeopleProvider {
    private final String sourceFile;

    public FilePeopleProvider(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    @Override
    public List<Person> readPeople() {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            return reader.lines()
                    .map(this::mapToPerson)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

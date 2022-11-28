package io.mbm.homework.exercise2.composition;

import io.mbm.homework.exercise2.Person;
import lombok.SneakyThrows;

import java.util.List;

public class PeopleReportGenerator {
    private final PeopleProvider peopleProvider;
    private final PeopleReportWriter reportWriter;

    public PeopleReportGenerator(PeopleProvider peopleProvider, PeopleReportWriter reportWriter) {
        this.peopleProvider = peopleProvider;
        this.reportWriter = reportWriter;
    }

    @SneakyThrows
    public void generateReport() {
        List<Person> people = peopleProvider.readPeople();
        reportWriter.writeReport(people);
    }

    public PeopleProvider getPeopleProvider() {
        return peopleProvider;
    }

    public PeopleReportWriter getReportWriter() {
        return reportWriter;
    }
}

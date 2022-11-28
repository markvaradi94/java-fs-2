package io.mbm.homework.exercise2.composition;

import io.mbm.homework.exercise2.Person;

import java.util.List;

public interface PeopleReportWriter {
    void writeReport(List<Person> people);
}

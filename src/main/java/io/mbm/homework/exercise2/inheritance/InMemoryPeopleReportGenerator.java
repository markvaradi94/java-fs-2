package io.mbm.homework.exercise2.inheritance;

import io.mbm.homework.exercise2.Person;

import java.util.List;

public class InMemoryPeopleReportGenerator extends PersonReportGenerator {
    @Override
    protected List<Person> readPeople() {
        return List.of(
                Person.builder()
                        .firstName("Gyuszi")
                        .lastName("Kovacs")
                        .age(25)
                        .build(),
                Person.builder()
                        .firstName("Laci")
                        .lastName("Szabo")
                        .age(47)
                        .build(),
                Person.builder()
                        .firstName("Ion")
                        .lastName("Popescu")
                        .age(55)
                        .build(),
                Person.builder()
                        .firstName("Ghita")
                        .lastName("Munteanu")
                        .age(44)
                        .build()
        );
    }
}

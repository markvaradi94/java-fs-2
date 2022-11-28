package io.mbm.homework;

import io.mbm.homework.exercise2.composition.FilePeopleProvider;
import io.mbm.homework.exercise2.composition.FilePeopleReportWriter;
import io.mbm.homework.exercise2.composition.InMemoryPeopleProvider;
import io.mbm.homework.exercise2.composition.PeopleReportGenerator;
import io.mbm.homework.exercise2.inheritance.FilePeopleReportGenerator;
import io.mbm.homework.exercise2.inheritance.InMemoryPeopleReportGenerator;

import static io.mbm.homework.exercise1.Planet.*;

public class HomeworkMain {
    public static void main(String[] args) {
        System.out.println(NEPTUNE.equivalentWeightOnEarth(70.5));
        System.out.println(JUPITER.equivalentWeightOnEarth(70.5));
        System.out.println(SUN.equivalentWeightOnEarth(70.5));
        System.out.println(WHITE_DWARF.equivalentWeightOnEarth(70.5));

        System.out.println("=========================================================================");

        var inheritanceFileGenerator = new FilePeopleReportGenerator("src/main/resources/people.txt");
        inheritanceFileGenerator.generateReport("src/main/resources/people-inheritance-1.txt");

        var inheritanceInMemoryGenerator = new InMemoryPeopleReportGenerator();
        inheritanceInMemoryGenerator.generateReport("src/main/resources/people-inheritance-2.txt");

        var compositionInMemoryGenerator = new PeopleReportGenerator(new InMemoryPeopleProvider(), new FilePeopleReportWriter("src/main/resources/people-composition-1.txt"));
        compositionInMemoryGenerator.generateReport();

        var compositionFileGenerator = new PeopleReportGenerator(new FilePeopleProvider("src/main/resources/people.txt"), new FilePeopleReportWriter("src/main/resources/people-composition-2.txt"));
        compositionFileGenerator.generateReport();
    }
}

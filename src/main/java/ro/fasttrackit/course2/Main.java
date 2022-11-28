package ro.fasttrackit.course2;


import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import io.mbm.homework.exercise2.Person;
import ro.fasttrackit.course2.countries.FileCountryReportGenerator;
import ro.fasttrackit.course2.countries.InMemoryCountryReportGenerator;
import ro.fasttrackit.course2.countries.composition.InMemoryCountryProvider;
import ro.fasttrackit.course2.countries.composition.ReportGenerator;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        var generator = new FileCountryReportGenerator("src/main/resources/countries.txt");
        generator.generateReport("src/main/resources/output.txt");

        var inMemoryGenerator = new InMemoryCountryReportGenerator();
        inMemoryGenerator.generateReport("src/main/resources/romania.txt");

        var inMemoryReportGenerator = new ReportGenerator(new InMemoryCountryProvider());
        inMemoryReportGenerator.generateReport("src/main/resources/moldova.txt");

        Person youngerDude = Person.builder()
                .firstName("Beluci")
                .lastName("Sunkaci")
                .age(69)
                .build();

        Person olderDude = Person.builder()
                .firstName("Markuci")
                .lastName("Erduci")
                .age(69)
                .build();

        var map1 = Collections.singletonMap("test", "youngerDude");
        var map2 = Collections.singletonMap("test", "olderDude");

        DiffNode diff = ObjectDifferBuilder.buildDefault().compare(youngerDude, olderDude);

        System.out.println(diff);
    }
}

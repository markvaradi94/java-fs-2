package io.mbm.homework.exercise2;

import lombok.Builder;
import lombok.With;

import static io.mbm.homework.exercise2.AgeGroup.determineAgeGroup;

@With
@Builder
public record Person(
        String firstName,
        String lastName,
        Integer age,
        AgeGroup ageGroup  // shouldn't be tied to the Person --> not good to have logic inside domain
) {
    public Person {
        ageGroup = determineAgeGroup(age);
    }
}

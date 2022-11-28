package io.mbm.homework.exercise2;

public enum AgeGroup {
    YOUNG("1-30"),
    ADULT("30-50"),
    OLD("60+");

    private final String groupKey;

    AgeGroup(String groupKey) {
        this.groupKey = groupKey;
    }

    static AgeGroup determineAgeGroup(int age) {
        if (age < 30 && age > 0) {
            return YOUNG;
        } else if (age < 50) {
            return ADULT;
        } else {
            return OLD;
        }
    }

    public String getGroupKey() {
        return groupKey;
    }
}

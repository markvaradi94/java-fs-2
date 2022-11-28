package io.mbm.homework.exercise1;

import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;

public enum Planet {
    MERCURY(0.3),
    VENUS(0.9),
    MOON(0.1),
    MARS(0.3),
    JUPITER(2.5),
    SATURN(1),
    URANUS(0.8),
    NEPTUNE(1.1),
    PLUTO(0),
    IO(0.18),
    EUROPA(0.13),
    GANYMEDE(0.14),
    CALLISTO(0.12),
    SUN(27),
    WHITE_DWARF(1_300_000);

    private final double gravityRatio;

    Planet(double gravityRatio) {
        this.gravityRatio = gravityRatio;
    }

    public double equivalentWeightOnEarth(double weight) {
        DecimalFormat df = new DecimalFormat("#.#");
        double equivalentWeight = weight * gravityRatio;
        return parseDouble(df.format(equivalentWeight));
    }

    @Override
    public String toString() {
        return "Planet{" +
                "gravityRatio=" + gravityRatio +
                '}';
    }
}

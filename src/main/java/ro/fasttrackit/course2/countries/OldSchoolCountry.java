package ro.fasttrackit.course2.countries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;
import static java.util.Optional.ofNullable;

public class OldSchoolCountry implements ICountry {
    private final String name;
    private final String capital;
    private final long population;
    private final long area;
    private final Continent continent;
    private final List<String> neighbours;

    private OldSchoolCountry() {
        this.name = null;
        this.capital = null;
        this.population = 0;
        this.area = 0;
        this.continent = null;
        this.neighbours = new ArrayList<>();
    }

    private OldSchoolCountry(String name, String capital, long population, long area, Continent continent, List<String> neighbours) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbours = ofNullable(neighbours)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public static CountryBuilder builder() {
        return new CountryBuilder();
    }

    public String name() {
        return name;
    }

    public String capital() {
        return capital;
    }

    public long population() {
        return population;
    }

    public long area() {
        return area;
    }

    public Continent continent() {
        return continent;
    }

    public List<String> neighbours() {
        return unmodifiableList(neighbours);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldSchoolCountry that = (OldSchoolCountry) o;
        return population == that.population && area == that.area && Objects.equals(name, that.name) && Objects.equals(capital, that.capital) && Objects.equals(continent, that.continent) && Objects.equals(neighbours, that.neighbours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capital, population, area, continent, neighbours);
    }

    @Override
    public String toString() {
        return "OldSchoolCountry{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", continent='" + continent + '\'' +
                ", neighbours=" + neighbours +
                '}';
    }

    public static class CountryBuilder {
        private final List<String> neighbours = new ArrayList<>();
        private String name;
        private String capital;
        private long population;
        private long area;
        private Continent continent;

        public static OldSchoolCountry country() {
            return new OldSchoolCountry();
        }

        public CountryBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CountryBuilder capital(String capital) {
            this.capital = capital;
            return this;
        }

        public CountryBuilder population(long population) {
            this.population = population;
            return this;
        }

        public CountryBuilder area(long area) {
            this.area = area;
            return this;
        }

        public CountryBuilder continent(String continent) {
            this.continent = Continent.valueOf(continent);
            return this;
        }

        public CountryBuilder continent(Continent continent) {
            this.continent = continent;
            return this;
        }

        public CountryBuilder neighbour(String neighbour) {
            this.neighbours.add(neighbour);
            return this;
        }

        public CountryBuilder neighbours(List<String> neighbours) {
            this.neighbours.addAll(neighbours);
            return this;
        }

        public OldSchoolCountry build() {
            return new OldSchoolCountry(name, capital, population, area, continent, neighbours);
        }
    }
}

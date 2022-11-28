package ro.fasttrackit.course2.countries;

import lombok.Builder;
import lombok.With;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.Optional.ofNullable;

@With
@Builder
public record Country(
        String name,
        String capital,
        long population,
        long area,
        Continent continent,
        List<String> neighbours
) implements ICountry {
    public Country {
        neighbours = ofNullable(neighbours)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    @Override
    public List<String> neighbours() {
        return unmodifiableList(neighbours);
    }
}

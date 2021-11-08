package coding.challenge2.restCountries;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.List;

public class CapitalCity {
    List<String> capital;

    public CapitalCity(List<String> countryCapitals) {
        this.capital = countryCapitals;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        CapitalCity comparator =(CapitalCity) obj;
        return new EqualsBuilder()
                .append(capital,comparator.capital)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(8,38)
                .append(capital)
                .toHashCode();
    }

    @Override
    public String toString() {
        return capital.get(0);
    }
}

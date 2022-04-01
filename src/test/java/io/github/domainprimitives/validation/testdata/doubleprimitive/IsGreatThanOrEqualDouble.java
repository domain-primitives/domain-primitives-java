package io.github.domainprimitives.validation.testdata.doubleprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

import static io.github.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class IsGreatThanOrEqualDouble extends ValueObject<Double> {
    public IsGreatThanOrEqualDouble(Double value) {
        super(value, Constraints.isGreatThanOrEqual(0.5));
    }
}

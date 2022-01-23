package de.novatec.domainprimitives.validation.testdata.doubleprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class IsGreatThanOrEqualDouble extends ValueObject<Double> {
    public IsGreatThanOrEqualDouble(Double value) {
        super(value, isGreatThanOrEqual(0.5));
    }
}

package de.novatec.ddd.domainprimitives.validation.testdata.doubleprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class IsGreatThanOrEqualDouble extends ValueObject<Double> {
    public IsGreatThanOrEqualDouble(Double value) {
        super(value, isGreatThanOrEqual(0.5));
    }
}

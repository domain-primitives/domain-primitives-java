package de.novatec.domainprimitives.validation.testdata.doubleprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isLessThanOrEqual;

public class IsLessThanOrEqualDouble extends ValueObject<Double> {
    public IsLessThanOrEqualDouble(Double value) {
        super(value, isLessThanOrEqual(1.0));
    }
}

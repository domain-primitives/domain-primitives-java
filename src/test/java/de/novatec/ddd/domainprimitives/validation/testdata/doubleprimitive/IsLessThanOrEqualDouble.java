package de.novatec.ddd.domainprimitives.validation.testdata.doubleprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isLessThanOrEqual;

public class IsLessThanOrEqualDouble extends ValueObject<Double> {
    public IsLessThanOrEqualDouble(Double value) {
        super(value, isLessThanOrEqual(1.0));
    }
}

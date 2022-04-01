package io.github.domainprimitives.validation.testdata.doubleprimitive;

import io.github.domainprimitives.type.ValueObject;

import static io.github.domainprimitives.validation.Constraints.isLessThanOrEqual;

public class IsLessThanOrEqualDouble extends ValueObject<Double> {
    public IsLessThanOrEqualDouble(Double value) {
        super(value, isLessThanOrEqual(1.0));
    }
}

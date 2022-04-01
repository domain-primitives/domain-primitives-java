package io.github.domainprimitives.validation.testdata.doubleprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

import static io.github.domainprimitives.validation.Constraints.isBetween;

public class IsBetweenDouble extends ValueObject<Double> {
    public IsBetweenDouble(Double value) {
        super(value, Constraints.isBetween(0.5, 1.5));
    }
}

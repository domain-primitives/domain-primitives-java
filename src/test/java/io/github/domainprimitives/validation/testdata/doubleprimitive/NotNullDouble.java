package io.github.domainprimitives.validation.testdata.doubleprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

public class NotNullDouble extends ValueObject<Double> {
    public NotNullDouble(Double value) {
        super(value, Constraints.isNotNullDouble());
    }
}

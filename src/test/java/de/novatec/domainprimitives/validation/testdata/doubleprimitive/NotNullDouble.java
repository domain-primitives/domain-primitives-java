package de.novatec.domainprimitives.validation.testdata.doubleprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isNotNullDouble;

public class NotNullDouble extends ValueObject<Double> {
    public NotNullDouble(Double value) {
        super(value, isNotNullDouble());
    }
}

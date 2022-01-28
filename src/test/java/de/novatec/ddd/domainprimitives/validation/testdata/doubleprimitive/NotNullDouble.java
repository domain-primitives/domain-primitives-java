package de.novatec.ddd.domainprimitives.validation.testdata.doubleprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isNotNullDouble;

public class NotNullDouble extends ValueObject<Double> {
    public NotNullDouble(Double value) {
        super(value, isNotNullDouble());
    }
}

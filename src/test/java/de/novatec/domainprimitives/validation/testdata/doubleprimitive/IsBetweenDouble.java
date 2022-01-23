package de.novatec.domainprimitives.validation.testdata.doubleprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isBetween;

public class IsBetweenDouble extends ValueObject<Double> {
    public IsBetweenDouble(Double value) {
        super(value, isBetween(0.5, 1.5));
    }
}

package de.novatec.ddd.domainprimitives.validation.testdata.doubleprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isBetween;

public class IsBetweenDouble extends ValueObject<Double> {
    public IsBetweenDouble(Double value) {
        super(value, isBetween(0.5, 1.5));
    }
}

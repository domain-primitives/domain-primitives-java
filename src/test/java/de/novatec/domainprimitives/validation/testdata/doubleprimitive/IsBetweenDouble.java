package de.novatec.domainprimitives.validation.testdata.doubleprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isBetween;

public class IsBetweenDouble extends PrimitiveType<Double> {
    public IsBetweenDouble(Double value) {
        super(value, "IsBetweenDouble", isBetween(0.5, 1.5));
    }
}

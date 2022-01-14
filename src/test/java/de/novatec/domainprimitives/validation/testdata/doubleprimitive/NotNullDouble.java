package de.novatec.domainprimitives.validation.testdata.doubleprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isNotNullDouble;

public class NotNullDouble extends PrimitiveType<Double> {
    public NotNullDouble(Double value) {
        super(value, "NotNullDouble", isNotNullDouble());
    }
}

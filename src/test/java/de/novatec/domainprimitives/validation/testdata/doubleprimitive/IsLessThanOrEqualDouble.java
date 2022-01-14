package de.novatec.domainprimitives.validation.testdata.doubleprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isLessThanOrEqual;

public class IsLessThanOrEqualDouble extends PrimitiveType<Double> {
    public IsLessThanOrEqualDouble(Double value) {
        super(value, "IsLessThanOrEqualDouble", isLessThanOrEqual(1.0));
    }
}

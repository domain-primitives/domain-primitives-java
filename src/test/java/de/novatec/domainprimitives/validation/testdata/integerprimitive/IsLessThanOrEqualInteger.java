package de.novatec.domainprimitives.validation.testdata.integerprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isLessThanOrEqual;

public class IsLessThanOrEqualInteger extends PrimitiveType<Integer> {
    public IsLessThanOrEqualInteger(Integer value) {
        super(value, isLessThanOrEqual(4));
    }
}

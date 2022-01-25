package de.novatec.domainprimitives.validation.testdata.integerprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isLessThanOrEqual;

public class IsLessThanOrEqualInteger extends ValueObject<Integer> {
    public IsLessThanOrEqualInteger(Integer value) {
        super(value, isLessThanOrEqual(4));
    }
}

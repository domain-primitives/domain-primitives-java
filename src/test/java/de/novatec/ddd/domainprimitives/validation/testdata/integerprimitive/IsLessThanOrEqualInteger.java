package de.novatec.ddd.domainprimitives.validation.testdata.integerprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;
import de.novatec.ddd.domainprimitives.validation.Constraints;

public class IsLessThanOrEqualInteger extends ValueObject<Integer> {
    public IsLessThanOrEqualInteger(Integer value) {
        super(value, Constraints.isLessThanOrEqual(4));
    }
}

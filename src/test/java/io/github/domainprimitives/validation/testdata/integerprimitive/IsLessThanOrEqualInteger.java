package io.github.domainprimitives.validation.testdata.integerprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

public class IsLessThanOrEqualInteger extends ValueObject<Integer> {
    public IsLessThanOrEqualInteger(Integer value) {
        super(value, Constraints.isLessThanOrEqual(4));
    }
}

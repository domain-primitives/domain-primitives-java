package io.github.domainprimitives.validation.testdata.integerprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

public class IsBetweenInteger extends ValueObject<Integer> {
    public IsBetweenInteger(Integer value) {
        super(value, Constraints.isInRange(1, 4));
    }
}

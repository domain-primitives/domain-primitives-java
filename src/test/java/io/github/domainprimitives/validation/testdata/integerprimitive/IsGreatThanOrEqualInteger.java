package io.github.domainprimitives.validation.testdata.integerprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

import static io.github.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class IsGreatThanOrEqualInteger extends ValueObject<Integer> {
    public IsGreatThanOrEqualInteger(Integer value) {
        super(value, Constraints.isGreatThanOrEqual(4));
    }
}

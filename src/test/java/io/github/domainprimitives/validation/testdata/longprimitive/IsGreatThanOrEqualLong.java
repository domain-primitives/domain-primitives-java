package io.github.domainprimitives.validation.testdata.longprimitive;

import io.github.domainprimitives.type.ValueObject;

import static io.github.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class IsGreatThanOrEqualLong extends ValueObject<Long> {
    public IsGreatThanOrEqualLong(Long value) {
        super(value, isGreatThanOrEqual(4L));
    }
}

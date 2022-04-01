package io.github.domainprimitives.validation.testdata.longprimitive;

import io.github.domainprimitives.type.ValueObject;

import static io.github.domainprimitives.validation.Constraints.isLessThanOrEqual;

public class IsLessThanOrEqualLong extends ValueObject<Long> {
    public IsLessThanOrEqualLong(Long value) {
        super(value, isLessThanOrEqual(4L));
    }
}

package io.github.domainprimitives.validation.testdata.longprimitive;

import io.github.domainprimitives.type.ValueObject;

import static io.github.domainprimitives.validation.Constraints.isBetween;

public class IsBetweenLong extends ValueObject<Long> {
    public IsBetweenLong(Long value) {
        super(value, isBetween(1L, 4L));
    }
}

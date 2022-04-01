package io.github.domainprimitives.validation.testdata.longprimitive;

import io.github.domainprimitives.type.ValueObject;

import static io.github.domainprimitives.validation.Constraints.isNotNullLong;

public class NotNullLong extends ValueObject<Long> {
    public NotNullLong(Long value) {
        super(value, isNotNullLong());
    }
}

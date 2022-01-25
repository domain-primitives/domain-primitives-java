package de.novatec.domainprimitives.validation.testdata.longprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isBetween;

public class IsBetweenLong extends ValueObject<Long> {
    public IsBetweenLong(Long value) {
        super(value, isBetween(1L, 4L));
    }
}

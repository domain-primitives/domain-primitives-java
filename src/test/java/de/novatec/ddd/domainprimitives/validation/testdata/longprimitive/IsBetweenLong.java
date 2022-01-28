package de.novatec.ddd.domainprimitives.validation.testdata.longprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isBetween;

public class IsBetweenLong extends ValueObject<Long> {
    public IsBetweenLong(Long value) {
        super(value, isBetween(1L, 4L));
    }
}

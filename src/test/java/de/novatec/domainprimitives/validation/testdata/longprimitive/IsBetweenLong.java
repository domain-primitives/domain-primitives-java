package de.novatec.domainprimitives.validation.testdata.longprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isBetween;

public class IsBetweenLong extends PrimitiveType<Long> {
    public IsBetweenLong(Long value) {
        super(value, "IsBetweenLong", isBetween(1L, 4L));
    }
}

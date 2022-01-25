package de.novatec.domainprimitives.validation.testdata.longprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isLessThanOrEqual;

public class IsLessThanOrEqualLong extends ValueObject<Long> {
    public IsLessThanOrEqualLong(Long value) {
        super(value, isLessThanOrEqual(4L));
    }
}

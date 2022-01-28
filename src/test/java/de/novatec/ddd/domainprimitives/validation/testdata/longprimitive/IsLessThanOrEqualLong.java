package de.novatec.ddd.domainprimitives.validation.testdata.longprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isLessThanOrEqual;

public class IsLessThanOrEqualLong extends ValueObject<Long> {
    public IsLessThanOrEqualLong(Long value) {
        super(value, isLessThanOrEqual(4L));
    }
}

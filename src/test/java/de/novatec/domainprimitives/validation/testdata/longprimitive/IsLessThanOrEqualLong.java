package de.novatec.domainprimitives.validation.testdata.longprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isLessThanOrEqual;

public class IsLessThanOrEqualLong extends PrimitiveType<Long> {
    public IsLessThanOrEqualLong(Long value) {
        super(value, "IsLessThanOrEqualLong", isLessThanOrEqual(4L));
    }
}

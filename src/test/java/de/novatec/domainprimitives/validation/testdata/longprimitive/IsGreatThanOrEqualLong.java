package de.novatec.domainprimitives.validation.testdata.longprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class IsGreatThanOrEqualLong extends PrimitiveType<Long> {
    public IsGreatThanOrEqualLong(Long value) {
        super(value, "IsGreatThanOrEqualLong", isGreatThanOrEqual(4L));
    }
}

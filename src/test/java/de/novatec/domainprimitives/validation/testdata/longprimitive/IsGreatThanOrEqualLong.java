package de.novatec.domainprimitives.validation.testdata.longprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class IsGreatThanOrEqualLong extends ValueObject<Long> {
    public IsGreatThanOrEqualLong(Long value) {
        super(value, isGreatThanOrEqual(4L));
    }
}

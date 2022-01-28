package de.novatec.ddd.domainprimitives.validation.testdata.longprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class IsGreatThanOrEqualLong extends ValueObject<Long> {
    public IsGreatThanOrEqualLong(Long value) {
        super(value, isGreatThanOrEqual(4L));
    }
}

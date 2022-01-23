package de.novatec.domainprimitives.validation.testdata.longprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isNotNullLong;

public class NotNullLong extends ValueObject<Long> {
    public NotNullLong(Long value) {
        super(value, isNotNullLong());
    }
}

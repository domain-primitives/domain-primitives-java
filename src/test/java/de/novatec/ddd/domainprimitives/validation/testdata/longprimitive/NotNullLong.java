package de.novatec.ddd.domainprimitives.validation.testdata.longprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isNotNullLong;

public class NotNullLong extends ValueObject<Long> {
    public NotNullLong(Long value) {
        super(value, isNotNullLong());
    }
}

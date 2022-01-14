package de.novatec.domainprimitives.validation.testdata.longprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isNotNullLong;

public class NotNullLong extends PrimitiveType<Long> {
    public NotNullLong(Long value) {
        super(value, "NotNullLong", isNotNullLong());
    }
}

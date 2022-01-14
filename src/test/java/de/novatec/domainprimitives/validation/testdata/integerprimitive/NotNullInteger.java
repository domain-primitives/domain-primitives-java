package de.novatec.domainprimitives.validation.testdata.integerprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isNotNullInteger;

public class NotNullInteger extends PrimitiveType<Integer> {
    public NotNullInteger(Integer value) {
        super(value, "NotNullInteger", isNotNullInteger());
    }
}

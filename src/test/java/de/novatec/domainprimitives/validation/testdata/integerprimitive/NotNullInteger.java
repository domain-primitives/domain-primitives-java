package de.novatec.domainprimitives.validation.testdata.integerprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isNotNullInteger;

public class NotNullInteger extends ValueObject<Integer> {
    public NotNullInteger(Integer value) {
        super(value, isNotNullInteger());
    }
}

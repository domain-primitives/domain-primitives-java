package de.novatec.ddd.domainprimitives.validation.testdata.integerprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isNotNullInteger;

public class NotNullInteger extends ValueObject<Integer> {
    public NotNullInteger(Integer value) {
        super(value, isNotNullInteger());
    }
}

package de.novatec.ddd.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.hasMaxLength;

public class MaxLengthString extends ValueObject<String> {
    public MaxLengthString(String value) {
        super(value, hasMaxLength(5));
    }
}

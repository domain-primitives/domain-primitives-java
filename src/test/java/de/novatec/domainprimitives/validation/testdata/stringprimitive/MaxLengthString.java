package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.hasMaxLength;

public class MaxLengthString extends ValueObject<String> {
    public MaxLengthString(String value) {
        super(value, hasMaxLength(5));
    }
}

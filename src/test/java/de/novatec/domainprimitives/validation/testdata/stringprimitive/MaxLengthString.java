package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.hasMaxLength;

public class MaxLengthString extends PrimitiveType<String> {
    public MaxLengthString(String value) {
        super(value, hasMaxLength(5));
    }
}

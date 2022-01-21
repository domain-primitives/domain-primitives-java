package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.hasMinLength;

public class MinLengthString extends PrimitiveType<String> {
    public MinLengthString(String value) {
        super(value, hasMinLength(3));
    }
}

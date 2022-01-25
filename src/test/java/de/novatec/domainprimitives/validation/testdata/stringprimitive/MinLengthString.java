package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.hasMinLength;

public class MinLengthString extends ValueObject<String> {
    public MinLengthString(String value) {
        super(value, hasMinLength(3));
    }
}

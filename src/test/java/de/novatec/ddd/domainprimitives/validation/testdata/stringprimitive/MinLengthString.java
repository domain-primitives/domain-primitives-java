package de.novatec.ddd.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.hasMinLength;

public class MinLengthString extends ValueObject<String> {
    public MinLengthString(String value) {
        super(value, hasMinLength(3));
    }
}

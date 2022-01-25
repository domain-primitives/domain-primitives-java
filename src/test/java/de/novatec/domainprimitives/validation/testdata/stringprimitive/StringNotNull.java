package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isNotNull;

public class StringNotNull extends ValueObject<String> {
    public StringNotNull(String value) {
        super(value, isNotNull());
    }
}

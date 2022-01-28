package de.novatec.ddd.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isNotNull;

public class StringNotNull extends ValueObject<String> {
    public StringNotNull(String value) {
        super(value, isNotNull());
    }
}

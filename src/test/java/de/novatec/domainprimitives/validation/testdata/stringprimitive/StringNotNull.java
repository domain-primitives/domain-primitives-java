package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isNotNull;

public class StringNotNull extends PrimitiveType<String> {
    public StringNotNull(String value) {
        super(value, isNotNull());
    }
}

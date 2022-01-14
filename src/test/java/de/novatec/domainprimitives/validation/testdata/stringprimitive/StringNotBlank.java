package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isNotBlank;

public class StringNotBlank extends PrimitiveType<String> {
    public StringNotBlank(String value) {
        super(value, "StringNotBlank", isNotBlank());
    }
}

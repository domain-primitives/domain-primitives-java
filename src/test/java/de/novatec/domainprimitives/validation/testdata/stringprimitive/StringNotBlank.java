package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isNotBlank;

public class StringNotBlank extends ValueObject<String> {
    public StringNotBlank(String value) {
        super(value, isNotBlank());
    }
}

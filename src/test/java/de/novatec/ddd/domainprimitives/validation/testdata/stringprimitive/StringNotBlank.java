package de.novatec.ddd.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isNotBlank;

public class StringNotBlank extends ValueObject<String> {
    public StringNotBlank(String value) {
        super(value, isNotBlank());
    }
}

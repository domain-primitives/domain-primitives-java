package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isPattern;

public class StringPattern extends ValueObject<String> {
    public StringPattern(String value) {
        super(value, isPattern("^[a-zA-Z]+$"));
    }
}

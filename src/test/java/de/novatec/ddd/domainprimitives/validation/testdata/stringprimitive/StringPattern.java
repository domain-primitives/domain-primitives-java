package de.novatec.ddd.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isPattern;

public class StringPattern extends ValueObject<String> {
    public StringPattern(String value) {
        super(value, isPattern("^[a-zA-Z]+$"));
    }
}

package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isPattern;

public class StringPattern extends PrimitiveType<String> {
    public StringPattern(String value) {
        super(value, isPattern("^[a-zA-Z]+$"));
    }
}

package io.github.domainprimitives.validation.testdata.stringprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

public class StringPattern extends ValueObject<String> {
    public StringPattern(String value) {
        super(value, Constraints.isPattern("^[a-zA-Z]+$"));
    }
}

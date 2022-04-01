package io.github.domainprimitives.validation.testdata.stringprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

public class StringNotNull extends ValueObject<String> {
    public StringNotNull(String value) {
        super(value, Constraints.isNotNull());
    }
}

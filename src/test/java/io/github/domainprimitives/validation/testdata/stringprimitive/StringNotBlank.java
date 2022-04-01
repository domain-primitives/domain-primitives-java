package io.github.domainprimitives.validation.testdata.stringprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

public class StringNotBlank extends ValueObject<String> {
    public StringNotBlank(String value) {
        super(value, Constraints.isNotBlank());
    }
}

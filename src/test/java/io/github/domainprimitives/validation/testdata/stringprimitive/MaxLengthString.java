package io.github.domainprimitives.validation.testdata.stringprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

public class MaxLengthString extends ValueObject<String> {
    public MaxLengthString(String value) {
        super(value, Constraints.hasMaxLength(5));
    }
}

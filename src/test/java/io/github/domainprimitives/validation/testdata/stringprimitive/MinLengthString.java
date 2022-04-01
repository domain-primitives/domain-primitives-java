package io.github.domainprimitives.validation.testdata.stringprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

public class MinLengthString extends ValueObject<String> {
    public MinLengthString(String value) {
        super(value, Constraints.hasMinLength(3));
    }
}

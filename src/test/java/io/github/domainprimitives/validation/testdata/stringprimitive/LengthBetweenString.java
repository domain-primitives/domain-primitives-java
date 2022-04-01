package io.github.domainprimitives.validation.testdata.stringprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

import static io.github.domainprimitives.validation.Constraints.isBetween;

public class LengthBetweenString extends ValueObject<String> {
    public LengthBetweenString(String value) {
        super(value, Constraints.isBetween(3, 5));
    }
}

package io.github.domainprimitives.validation.testdata.integerprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

public class NotNullInteger extends ValueObject<Integer> {
    public NotNullInteger(Integer value) {
        super(value, Constraints.isNotNullInteger());
    }
}

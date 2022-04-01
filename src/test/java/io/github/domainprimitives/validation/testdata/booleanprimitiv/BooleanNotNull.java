package io.github.domainprimitives.validation.testdata.booleanprimitiv;

import io.github.domainprimitives.type.ValueObject;

import static io.github.domainprimitives.validation.Constraints.isNotNullBoolean;

public class BooleanNotNull extends ValueObject<Boolean> {
    public BooleanNotNull(Boolean value) {
        super(value, isNotNullBoolean());
    }
}

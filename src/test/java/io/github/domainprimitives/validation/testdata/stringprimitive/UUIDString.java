package io.github.domainprimitives.validation.testdata.stringprimitive;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;

public class UUIDString extends ValueObject<String> {
    public UUIDString(String value) {
        super(value, Constraints.isUUID());
    }
}

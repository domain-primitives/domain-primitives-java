package io.github.domainprimitives.object.testdata;

import io.github.domainprimitives.type.ValueObject;

import static io.github.domainprimitives.validation.Constraints.isNotBlank;

public class Name extends ValueObject<String> {
    public Name(String value) {
        super(value, isNotBlank());
    }
}

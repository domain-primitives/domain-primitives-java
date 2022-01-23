package de.novatec.domainprimitives.object.testdata;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isNotBlank;

public class Name extends ValueObject<String> {
    public Name(String value) {
        super(value, isNotBlank());
    }
}

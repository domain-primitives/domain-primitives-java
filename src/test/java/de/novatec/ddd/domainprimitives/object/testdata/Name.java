package de.novatec.ddd.domainprimitives.object.testdata;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isNotBlank;

public class Name extends ValueObject<String> {
    public Name(String value) {
        super(value, isNotBlank());
    }
}

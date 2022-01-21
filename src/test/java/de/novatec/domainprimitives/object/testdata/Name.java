package de.novatec.domainprimitives.object.testdata;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isNotBlank;

public class Name extends PrimitiveType<String> {
    public Name(String value) {
        super(value, isNotBlank());
    }
}

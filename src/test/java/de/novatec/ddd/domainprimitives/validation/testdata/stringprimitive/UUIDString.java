package de.novatec.ddd.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isUUID;

public class UUIDString extends ValueObject<String> {
    public UUIDString(String value) {
        super(value, isUUID());
    }
}

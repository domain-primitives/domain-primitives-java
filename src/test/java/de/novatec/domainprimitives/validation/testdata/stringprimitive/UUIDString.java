package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isUUID;

public class UUIDString extends ValueObject<String> {
    public UUIDString(String value) {
        super(value, isUUID());
    }
}

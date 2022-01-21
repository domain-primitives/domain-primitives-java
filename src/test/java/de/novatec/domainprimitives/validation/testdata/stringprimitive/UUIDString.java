package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isUUID;

public class UUIDString extends PrimitiveType<String> {
    public UUIDString(String value) {
        super(value, isUUID());
    }
}

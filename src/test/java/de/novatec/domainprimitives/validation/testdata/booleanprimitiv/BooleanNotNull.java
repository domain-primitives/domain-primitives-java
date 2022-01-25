package de.novatec.domainprimitives.validation.testdata.booleanprimitiv;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isNotNullBoolean;

public class BooleanNotNull extends ValueObject<Boolean> {
    public BooleanNotNull(Boolean value) {
        super(value, isNotNullBoolean());
    }
}

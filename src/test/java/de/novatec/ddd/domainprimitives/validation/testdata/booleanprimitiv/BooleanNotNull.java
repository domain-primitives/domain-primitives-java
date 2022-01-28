package de.novatec.ddd.domainprimitives.validation.testdata.booleanprimitiv;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isNotNullBoolean;

public class BooleanNotNull extends ValueObject<Boolean> {
    public BooleanNotNull(Boolean value) {
        super(value, isNotNullBoolean());
    }
}

package de.novatec.domainprimitives.validation.testdata.booleanprimitiv;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isNotNullBoolean;

public class BooleanNotNull extends PrimitiveType<Boolean> {
    public BooleanNotNull(Boolean value) {
        super(value, "BooleanNotNull", isNotNullBoolean());
    }
}

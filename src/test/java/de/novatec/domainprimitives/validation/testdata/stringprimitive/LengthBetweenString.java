package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isBetween;

public class LengthBetweenString extends PrimitiveType<String> {
    public LengthBetweenString(String value) {
        super(value, isBetween(3, 5));
    }
}

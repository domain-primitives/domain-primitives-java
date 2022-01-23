package de.novatec.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isBetween;

public class LengthBetweenString extends ValueObject<String> {
    public LengthBetweenString(String value) {
        super(value, isBetween(3, 5));
    }
}

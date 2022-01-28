package de.novatec.ddd.domainprimitives.validation.testdata.stringprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isBetween;

public class LengthBetweenString extends ValueObject<String> {
    public LengthBetweenString(String value) {
        super(value, isBetween(3, 5));
    }
}

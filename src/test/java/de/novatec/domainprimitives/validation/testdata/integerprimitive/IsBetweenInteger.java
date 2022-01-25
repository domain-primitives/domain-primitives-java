package de.novatec.domainprimitives.validation.testdata.integerprimitive;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isInRange;

public class IsBetweenInteger extends ValueObject<Integer> {
    public IsBetweenInteger(Integer value) {
        super(value, isInRange(1, 4));
    }
}

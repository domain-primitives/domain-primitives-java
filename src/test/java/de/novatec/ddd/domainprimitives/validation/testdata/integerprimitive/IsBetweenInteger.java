package de.novatec.ddd.domainprimitives.validation.testdata.integerprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;
import de.novatec.ddd.domainprimitives.validation.Constraints;

public class IsBetweenInteger extends ValueObject<Integer> {
    public IsBetweenInteger(Integer value) {
        super(value, Constraints.isInRange(1, 4));
    }
}

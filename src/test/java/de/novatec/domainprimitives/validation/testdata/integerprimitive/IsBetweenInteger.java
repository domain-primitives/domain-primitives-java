package de.novatec.domainprimitives.validation.testdata.integerprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isInRange;

public class IsBetweenInteger extends PrimitiveType<Integer> {
    public IsBetweenInteger(Integer value) {
        super(value, "IsBetweenInteger", isInRange(1, 4));
    }
}

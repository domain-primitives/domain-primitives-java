package de.novatec.domainprimitives.validation.testdata.integerprimitive;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class IsGreatThanOrEqualInteger extends PrimitiveType<Integer> {
    public IsGreatThanOrEqualInteger(Integer value) {
        super(value, isGreatThanOrEqual(4));
    }
}

package de.novatec.ddd.domainprimitives.validation.testdata.integerprimitive;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class IsGreatThanOrEqualInteger extends ValueObject<Integer> {
    public IsGreatThanOrEqualInteger(Integer value) {
        super(value, isGreatThanOrEqual(4));
    }
}

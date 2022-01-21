package de.novatec.domainprimitives.object.testdata;

import de.novatec.domainprimitives.type.PrimitiveType;

import static de.novatec.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class PersonId extends PrimitiveType<Long> {
    public PersonId(Long value) {
        super(value, isGreatThanOrEqual(1L));
    }
}

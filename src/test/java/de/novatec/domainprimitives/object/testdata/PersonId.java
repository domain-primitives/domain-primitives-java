package de.novatec.domainprimitives.object.testdata;

import de.novatec.domainprimitives.type.ValueObject;

import static de.novatec.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class PersonId extends ValueObject<Long> {
    public PersonId(Long value) {
        super(value, isGreatThanOrEqual(1L));
    }
}

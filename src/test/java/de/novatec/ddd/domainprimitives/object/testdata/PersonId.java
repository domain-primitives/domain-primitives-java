package de.novatec.ddd.domainprimitives.object.testdata;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class PersonId extends ValueObject<Long> {
    public PersonId(Long value) {
        super(value, isGreatThanOrEqual(1L));
    }
}

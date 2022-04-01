package io.github.domainprimitives.object.testdata;

import io.github.domainprimitives.type.ValueObject;

import static io.github.domainprimitives.validation.Constraints.isGreatThanOrEqual;

public class PersonId extends ValueObject<Long> {
    public PersonId(Long value) {
        super(value, isGreatThanOrEqual(1L));
    }
}

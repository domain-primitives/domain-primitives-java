package de.novatec.ddd.domainprimitives.validation.testdata.temporal;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import java.time.temporal.Temporal;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isInPast;

public class TemporalInPast extends ValueObject<Temporal> {
    public TemporalInPast(Temporal value) {
        super(value, isInPast());
    }
}

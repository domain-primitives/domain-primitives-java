package de.novatec.ddd.domainprimitives.validation.testdata.temporal;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import java.time.temporal.Temporal;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isInFuture;

public class TemporalInFuture extends ValueObject<Temporal> {
    public TemporalInFuture(Temporal value) {
        super(value, isInFuture());
    }
}

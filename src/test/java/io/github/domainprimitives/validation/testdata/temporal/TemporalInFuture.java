package io.github.domainprimitives.validation.testdata.temporal;

import io.github.domainprimitives.type.ValueObject;

import java.time.temporal.Temporal;

import static io.github.domainprimitives.validation.Constraints.isInFuture;

public class TemporalInFuture extends ValueObject<Temporal> {
    public TemporalInFuture(Temporal value) {
        super(value, isInFuture());
    }
}

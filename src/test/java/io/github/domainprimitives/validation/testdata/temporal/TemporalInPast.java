package io.github.domainprimitives.validation.testdata.temporal;

import io.github.domainprimitives.type.ValueObject;

import java.time.temporal.Temporal;

import static io.github.domainprimitives.validation.Constraints.isInPast;

public class TemporalInPast extends ValueObject<Temporal> {
    public TemporalInPast(Temporal value) {
        super(value, isInPast());
    }
}

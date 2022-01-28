package de.novatec.ddd.domainprimitives.validation.testdata.localdate;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import java.time.LocalDate;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isInFutureLocalDate;

public class LocalDateInFuture extends ValueObject<LocalDate> {
    public LocalDateInFuture(LocalDate value) {
        super(value, isInFutureLocalDate());
    }
}

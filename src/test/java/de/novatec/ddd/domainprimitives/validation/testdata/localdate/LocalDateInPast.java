package de.novatec.ddd.domainprimitives.validation.testdata.localdate;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import java.time.LocalDate;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isInPastLocalDate;

public class LocalDateInPast extends ValueObject<LocalDate> {
    public LocalDateInPast(LocalDate value) {
        super(value, isInPastLocalDate());
    }
}

package de.novatec.ddd.domainprimitives.validation.testdata.date;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import java.util.Date;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isInPast;

public class DateInPast extends ValueObject<Date> {
    public DateInPast(Date value) {
        super(value, isInPast());
    }
}

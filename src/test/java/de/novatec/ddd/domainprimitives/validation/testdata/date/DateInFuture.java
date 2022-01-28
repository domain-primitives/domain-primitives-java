package de.novatec.ddd.domainprimitives.validation.testdata.date;

import de.novatec.ddd.domainprimitives.type.ValueObject;

import java.util.Date;

import static de.novatec.ddd.domainprimitives.validation.Constraints.isInFuture;

public class DateInFuture extends ValueObject<Date> {
    public DateInFuture(Date value) {
        super(value, isInFuture());
    }
}

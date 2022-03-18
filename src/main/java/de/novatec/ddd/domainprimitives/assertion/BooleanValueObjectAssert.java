package de.novatec.ddd.domainprimitives.assertion;

import de.novatec.ddd.domainprimitives.type.BooleanValueObject;

public class BooleanValueObjectAssert<T extends BooleanValueObject> extends AbstractValueObjectAssert<BooleanValueObjectAssert<T>, T, Boolean> {
	public BooleanValueObjectAssert(T actual) {
		super(actual, BooleanValueObjectAssert.class);
	}
}

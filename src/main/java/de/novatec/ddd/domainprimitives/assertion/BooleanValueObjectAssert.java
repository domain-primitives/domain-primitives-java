package de.novatec.ddd.domainprimitives.assertion;

import de.novatec.ddd.domainprimitives.type.BooleanValueObject;
import org.assertj.core.api.BooleanAssert;

public class BooleanValueObjectAssert<T extends BooleanValueObject> extends AbstractValueObjectAssert<BooleanValueObjectAssert<T>, T, Boolean, BooleanAssert> {

	public BooleanValueObjectAssert(T actual) {
		super(actual, BooleanValueObjectAssert.class);
	}

	@Override
	public BooleanAssert value() {
		return new BooleanAssert(actual.getValue());
	}
}

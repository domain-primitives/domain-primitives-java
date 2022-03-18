package de.novatec.ddd.domainprimitives.assertion;

import de.novatec.ddd.domainprimitives.type.StringValueObject;
import org.assertj.core.api.StringAssert;

public class StringValueObjectAssert<T extends StringValueObject> extends AbstractValueObjectAssert<StringValueObjectAssert<T>, T, String, StringAssert> {

	public StringValueObjectAssert(T actual) {
		super(actual, StringValueObjectAssert.class);
	}

	public StringAssert value() {
		return new StringAssert(actual.getValue());
	}
}

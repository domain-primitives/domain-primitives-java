package de.novatec.ddd.domainprimitives.assertion;

import de.novatec.ddd.domainprimitives.type.BooleanValueObject;
import de.novatec.ddd.domainprimitives.type.StringValueObject;

public class ValueObjectAssertion {


	public static <T extends BooleanValueObject> BooleanValueObjectAssert<T> assertThat(T actual) {
		return new BooleanValueObjectAssert<>(actual);
	}

	public static <T extends StringValueObject> StringValueObjectAssert<T> assertThat(T actual) {
		return new StringValueObjectAssert<>(actual);
	}
}

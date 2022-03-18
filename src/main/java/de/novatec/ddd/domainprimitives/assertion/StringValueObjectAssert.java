package de.novatec.ddd.domainprimitives.assertion;

import de.novatec.ddd.domainprimitives.type.StringValueObject;

import static org.assertj.core.api.Assertions.assertThat;

public class StringValueObjectAssert<T extends StringValueObject> extends AbstractValueObjectAssert<StringValueObjectAssert<T>, T, String> {

	public StringValueObjectAssert(T actual) {
		super(actual, StringValueObjectAssert.class);
	}

	public StringValueObjectAssert<T> hasValueContaining(String value) {
		String errorMessage = "Expected ValueObject's value to be <%s>, but was <%s>.";
		String actualValue = actual.getValue();
		assertThat(actualValue).overridingErrorMessage(errorMessage, value, actualValue).contains(value);
		return myself;
	}
}

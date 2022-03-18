package de.novatec.ddd.domainprimitives.assertion;

import de.novatec.ddd.domainprimitives.type.ValueObject;
import org.assertj.core.api.AbstractAssert;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractValueObjectAssert<SELF extends AbstractValueObjectAssert<SELF, ACTUAL, ELEMENT>,
		ACTUAL extends ValueObject<ELEMENT>,
		ELEMENT>
		extends AbstractAssert<SELF, ACTUAL> {

	protected AbstractValueObjectAssert(ACTUAL actual, Class<?> selfType) {
		super(actual, selfType);
	}

	public SELF hasValue(ELEMENT value) {
		String errorMessage = "Expected ValueObject's value to be <%s>, but was <%s>.";
		ELEMENT actualValue = actual.getValue();
		assertThat(actualValue).overridingErrorMessage(errorMessage, value, actualValue).isEqualTo(value);
		return myself;
	}
}

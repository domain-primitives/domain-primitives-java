package de.novatec.ddd.domainprimitives.type;

import java.util.function.Consumer;

import de.novatec.ddd.domainprimitives.validation.Validation;

public class StringValueObject extends ValueObject<String> {

	public StringValueObject(String value) {
		super(value);
	}

	StringValueObject(String value, String label) {
		super(value, label);
	}

	StringValueObject(String value, Consumer<Validation<String>> constraints) {
		super(value, constraints);
	}

	StringValueObject(String value, String label, Consumer<Validation<String>> constraints) {
		super(value, label, constraints);
	}
}

package de.novatec.ddd.domainprimitives.type;

import java.util.function.Consumer;

import de.novatec.ddd.domainprimitives.validation.Validation;

public class BooleanValueObject extends ValueObject<Boolean> {

	public BooleanValueObject(Boolean value) {
		super(value);
	}

	BooleanValueObject(Boolean value, String label) {
		super(value, label);
	}

	BooleanValueObject(Boolean value, Consumer<Validation<Boolean>> constraints) {
		super(value, constraints);
	}

	BooleanValueObject(Boolean value, String label, Consumer<Validation<Boolean>> constraints) {
		super(value, label, constraints);
	}
}

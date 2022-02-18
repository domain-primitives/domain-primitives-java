package de.novatec.ddd.domainprimitives.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class ObjectValidation {

	private final List<Consumer<Void>> toValidate = new ArrayList<>();
	private final List<String> problems = new ArrayList<>();
	private String objectName;

	public ObjectValidation(Consumer<Void>[] validations) {
		toValidate.addAll(List.of(validations));
	}

	@SafeVarargs
	public static <T> ObjectValidation checks(Consumer<Void>... validations) {
		return new ObjectValidation(validations);
	}

	public static <T> Consumer<Void> check(T value, String label, Consumer<Validation<T>> constraint) {
		return var -> Validation.validate(value, label, constraint);
	}

	public void validate() {
		if (toValidate.isEmpty()) {
			//TODO Logger
			System.out.println("No Validations found for Object: " + objectName);
		}
		else {
			toValidate.forEach(check -> {
				try {
					check.accept(null);
				}
				catch (InvariantException e) {
					problems.add(e.getMessage());
				}
			});
			evaluateValidations();
		}
	}

	private void evaluateValidations() throws InvariantException {
		if (!problems.isEmpty()) throw new ObjectInvariantException(objectName, problems);
	}

	public void forObject(String objectName) {
		this.objectName = objectName;
	}
}

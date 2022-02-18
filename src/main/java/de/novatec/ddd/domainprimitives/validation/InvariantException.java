package de.novatec.ddd.domainprimitives.validation;

/**
 * InvariantException should be thrown during the validation of an object.
 * It is an unchecked exceptions, its superclass is {@link RuntimeException RuntimeException}.
 */
public class InvariantException extends RuntimeException {

	public InvariantException(String message) {
		super(message);
	}
}

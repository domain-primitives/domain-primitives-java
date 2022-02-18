package de.novatec.ddd.domainprimitives.validation;

import java.util.List;

import static java.lang.String.format;
import static java.lang.String.join;

public class ObjectInvariantException extends InvariantException {

	private static final String ERROR_MESSAGE_PATTERN = "Value(s) of %s is not valid:\r\n  %s";

	public ObjectInvariantException(String label, List<String> problems) {
		super(format(ERROR_MESSAGE_PATTERN, label, join("\r\n  ", problems)));
	}
}

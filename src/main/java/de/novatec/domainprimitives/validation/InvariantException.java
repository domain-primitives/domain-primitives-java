package de.novatec.domainprimitives.validation;

import java.util.List;

import static java.lang.String.format;
import static java.lang.String.join;

/**
 * InvariantException should be thrown during the validation of an object.
 * It is an unchecked exceptions, its superclass is {@link RuntimeException RuntimeException}.
 */
public class InvariantException extends RuntimeException {

    private static final String ERROR_MESSAGE_PATTERN = "%s of %s is not valid: %s.";

    /**
     * Constructs a new invariant exception (a runtime exception) with the following pattern: {@value #ERROR_MESSAGE_PATTERN},
     * e.g. "Value Name is not valid: Too long."
     * @param label The name of the object, which is not valid.
     * @param message The message describing the invalidity.
     */
    public InvariantException(String label, String message) {
        super(format(ERROR_MESSAGE_PATTERN, "Value", label, message));
    }

    /**
     * Constructs a new invariant exception (a runtime exception) for a list of invalidities for one lable.
     * The message will have the following pattern: {@value #ERROR_MESSAGE_PATTERN},
     * e.g. "Value(s) Name is not valid: Too long. No special characters allowed."
     * @param label The name of the object, which is not valid.
     * @param problems All messages describing each invalidity.
     */
    public InvariantException(String label, List<String> problems) {
        super(format(ERROR_MESSAGE_PATTERN, "Value(s)", label, join(". ", problems)));
    }
}

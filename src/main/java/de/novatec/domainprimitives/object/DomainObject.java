package de.novatec.domainprimitives.object;

import de.novatec.domainprimitives.validation.InvariantException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public abstract class DomainObject {

    private final List<String> violations = new ArrayList<>();

    protected DomainObject() {}

    /**
     * Providing a starting point this stub could be used check on invariant violations.
     */
    protected abstract void validate();

    /**
     * Helping validation method to ensure the field is not null
     *
     * @param field The object with should be null-checked
     * @param label The lable or a description of the field
     */
    protected void validateNotNull(Object field, String label) {
        if (field == null) {
            violations.add(format("%s should not be null", label));
        }
    }

    /**
     * If you have more complex validations than only null-checks,
     * the violation could be added to the final {@link InvariantException InvariantException}.
     *
     * @param violation Info about the violation.
     *                  Maybe which constraints are violated.
     */
    protected void addInvariantViolation(String violation) {
        this.violations.add(violation);
    }

    /**
     * Evaluate all invariants.
     *
     * @param name The Name of the class the invariants are defined.
     *             If not provided the default is the simple class name, see {@link #evaluateValidations() evaluateValidations} method.
     * @throws InvariantException containing all invariant violations.
     */
    protected void evaluateValidations(String name) throws InvariantException {
        if (!violations.isEmpty()) {
            throw new InvariantException(name, violations);
        }
    }

    /**
     * Evaluate all invariants.
     * The label describing the object, the invariants are checked on, is the simple class name.
     *
     * @throws InvariantException containing all invariant violations.
     */
    protected void evaluateValidations() throws InvariantException {
        this.evaluateValidations(this.getClass().getSimpleName());
    }
}

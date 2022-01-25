package de.novatec.domainprimitives.type;

import de.novatec.domainprimitives.validation.Constraints;
import de.novatec.domainprimitives.validation.Validation;

import java.util.function.Consumer;

import static de.novatec.domainprimitives.validation.Validation.none;

public abstract class ValueObject<T> {

    private final T value;
    private final String label;

    /**
     * Construct the object without any validation constrains.
     * The Object gets its simple class name as label, which is used,
     * e.g. for the {@link de.novatec.domainprimitives.validation.InvariantException InvariantException} message.
     *
     * @param value The immutable value the object should have.
     */
    public ValueObject(T value) {
        this(value, none());
    }

    /**
     * Construct the object without any validation constrains but a custom label, which is used,
     * e.g. for the {@link de.novatec.domainprimitives.validation.InvariantException InvariantException} message.
     *
     * @param value The inner value the object should have.
     * @param label The label or description of the object. Used e.g., for the {@link de.novatec.domainprimitives.validation.InvariantException InvariantException} message.
     */
    public ValueObject(T value, String label) {
        this(value, label, none());
    }

    /**
     * Construct the object with custom validation constrains and without a custom label (default is the simple class name).
     *
     * @param value The inner value the object should have.
     * @param constraints The constraints the value should satisfy.
     *                    Have a look at the constraints we provide {@link de.novatec.domainprimitives.validation.Constraints Constraints},
     *                    e.g. {@link Constraints#isNotBlank() isNotBlank()}.
     */
    public ValueObject(T value, Consumer<Validation<T>> constraints) {
        this.value = value;
        this.label = this.getClass().getSimpleName();
        runValidation(constraints);
    }

    /**
     * Construct the object with custom validation constrains and a custom label.
     *
     * @param value The inner value the object should have.
     * @param label The label or description of the object. Used e.g., for the {@link de.novatec.domainprimitives.validation.InvariantException InvariantException} message.
     * @param constraints The constraints the value should satisfy.
     *                    Have a look at the constraints we provide {@link de.novatec.domainprimitives.validation.Constraints Constraints},
     *                    e.g. {@link Constraints#isNotBlank() isNotBlank()}.
     */
    public ValueObject(T value, String label, Consumer<Validation<T>> constraints) {
        this.value = value;
        this.label = label;
        runValidation(constraints);
    }

    private void runValidation(Consumer<Validation<T>> constraints) {
        if (!none().equals(constraints)) {
            Validation.validate(value, label, constraints);
        }
    }

    public String getLabel() {
        return label;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (value == null) {
            return "";
        }
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueObject<?> valueObject = (ValueObject<?>) o;
        if (value == valueObject.value) return true;
        if (value instanceof String) {
            return value.equals(valueObject.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

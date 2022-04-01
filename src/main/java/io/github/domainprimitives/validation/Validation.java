package io.github.domainprimitives.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class Validation<T> {

    public static <T> Consumer<Validation<T>> none() {
        return validation -> {};
    }

    private final String label;
    private final T value;
    private final List<String> problems = new ArrayList<>();

    public Validation(String label, T value) {
        this.label = label;
        this.value = value;
    }

    public static <T> void validate(T value, String label, Consumer<Validation<T>> validations) throws InvariantException {
        Validation<T> validation = new Validation<>(label, value);
        validations.accept(validation);
        validation.validate();
    }

    public void addViolation(String problem) {
        problems.add(label + " " + problem);
    }

    private void validate() throws InvariantException {
        if (!problems.isEmpty()) throw new InvariantException(label, problems);
    }

    public void constraint(Boolean value, Supplier<String> descriptionSupplier) {
        if (Boolean.FALSE.equals(value)) addViolation(descriptionSupplier.get());
    }

    public T value() {
        return value;
    }
}

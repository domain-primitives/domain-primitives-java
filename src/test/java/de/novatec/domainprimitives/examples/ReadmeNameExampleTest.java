package de.novatec.domainprimitives.examples;

import de.novatec.domainprimitives.type.ValueObject;
import de.novatec.domainprimitives.validation.InvariantException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static de.novatec.domainprimitives.validation.Constraints.*;
import static org.junit.jupiter.api.Assertions.*;

class ReadmeNameExampleTest {

    @Test
    void should_create_valid_object() {
        String nameValue = "Peter";
        Name name = new Name(nameValue);
        assertNotNull(name);
        assertEquals(nameValue, name.getValue());
    }

    @Nested
    class InvariantTest {
        @Test
        void should_throw_invariant_exception_if_value_is_null() {
            InvariantException exception = assertThrows(
                    InvariantException.class,
                    () -> new Name(null));

            assertEquals(
                    "Value(s) of Name is not valid: Name (null) should not be null. Name (null) should be longer than 3. Name (null) should not be longer than 20.",
                    exception.getMessage());
        }

        @Test
        void should_throw_invariant_exception_if_value_is_to_short() {
            String value = "AB";
            InvariantException exception = assertThrows(
                    InvariantException.class,
                    () -> new Name(value));

            assertEquals(
                    "Value(s) of Name is not valid: Name (" + value + ") should be longer than 3.",
                    exception.getMessage());
        }

        @Test
        void should_throw_invariant_exception_if_value_is_to_long() {
            String value = "ABCDEFGHIJKLMNOPQRSTU";
            InvariantException exception = assertThrows(
                    InvariantException.class,
                    () -> new Name(value));

            assertEquals(
                    "Value(s) of Name is not valid: Name (" + value + ") should not be longer than 20.",
                    exception.getMessage());
        }
    }
}

class Name extends ValueObject<String> {
    public Name(String value) {
        super(value, isNotNull().andThen(hasMinLength(3).andThen(hasMaxLength(20))));
    }
}

package io.github.domainprimitives.object;

import io.github.domainprimitives.object.testdata.Name;
import io.github.domainprimitives.object.testdata.Person;
import io.github.domainprimitives.object.testdata.PersonId;
import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.InvariantException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DomainObjectTest {

    @Test
    void should_create_object_if_valid() {
        PersonId personId = new PersonId(1L);
        Name name = new Name("Peter");

        Person person = new Person(personId, name);

        assertNotNull(person);
        assertEquals(personId, person.getPersonId());
    }

    @Test
    void should_throw_invariant_exception_if_field_is_null() {
        Name name = new Name("Peter");
        InvariantException exception = assertThrows(InvariantException.class, () -> new Person(null, name));

        assertEquals("Value(s) of Person is not valid: Person ID should not be null.", exception.getMessage());
    }

    @Test
    void should_throw_invariant_exception_if_custom_violation() {
        PersonId personId = new PersonId(12L);
        Name name = new Name("Peter");
        InvariantException exception = assertThrows(InvariantException.class, () -> new Person(personId,name));

        assertEquals("Value(s) of Person is not valid: This is not allowed.", exception.getMessage());
    }

    @Test
    void should_throw_invariant_exception_if_field_is_null_with_multiple_fields() {
        InvariantException exception = assertThrows(InvariantException.class, () -> new Person(null, null));

        assertEquals("Value(s) of Person is not valid: Person ID should not be null. Name should not be null.", exception.getMessage());
    }

    @Test
    void should_be_equal_in_content_not_memory_location() {
        final IntergerValueObject first = new IntergerValueObject(128);
        final IntergerValueObject second = new IntergerValueObject(128);

        assertTrue(first.equals(second));
    }
}

class IntergerValueObject extends ValueObject<Integer> {
    public IntergerValueObject(Integer value) {
        super(value);
    }
}